import pytest
from app.repositorio_pedidos import RepositorioPedidos
from app.servicio_pedidos import ServicioPedidos


# Integración con Stub
class StubNotificador:
   def enviar_confirmacion(self, cliente, pedido_id):
     pass # No hace nada, solo permite que el flujo continúe

   def test_integracion_con_stub_crea_pedido():
       repo = RepositorioPedidos(db_path=":memory:")
       servicio = ServicioPedidos(repo, StubNotificador())
       pedido_id = servicio.crear_pedido("Ana", 150.0)
       assert isinstance(pedido_id, int)
       assert pedido_id > 0

# Integración con Mock
def test_integracion_con_mock_notificador(mocker):
    repo = RepositorioPedidos(db_path=":memory:")
    mock_notif = mocker.MagicMock()
    servicio = ServicioPedidos(repo, mock_notif)

    pedido_id = servicio.crear_pedido("Luis", 200.0)

    mock_notif.enviar_confirmacion.assert_called_once_with(
        "Luis", pedido_id
    )

# Integración con Base de Datos Real
def test_integracion_bd_real_persiste_datos():
    repo = RepositorioPedidos(db_path=":memory:")
    servicio = ServicioPedidos(repo, StubNotificador())

    pedido_id = servicio.crear_pedido("María", 300.0)
    fila = repo.obtener(pedido_id)

    assert fila is not None
    assert fila[1] == "María"  # cliente
    assert fila[2] == 300.0  # total
    assert fila[3] == "pendiente"  # estado por defecto

# Integración con Base de Datos Temporal
def test_integracion_bd_temporal_persiste_entre_conexiones(tmp_path):
    db_file = tmp_path / "test_pedidos.db"
    repo = RepositorioPedidos(db_path=str(db_file))
    servicio = ServicioPedidos(repo, StubNotificador())

    pedido_id = servicio.crear_pedido("Pedro", 50.0)

    # Nueva instancia del repositorio sobre el mismo archivo
    repo2 = RepositorioPedidos(db_path=str(db_file))
    fila = repo2.obtener(pedido_id)

    assert fila[1] == "Pedro"

# Integración con Manejo de Errores entre Componentes
def test_integracion_error_no_persiste_ni_notifica(mocker):
    mock_repo = mocker.MagicMock()
    mock_notif = mocker.MagicMock()
    servicio = ServicioPedidos(mock_repo, mock_notif)

    with pytest.raises(
        ValueError, match="El total debe ser mayor a cero"
    ):
        servicio.crear_pedido("Error", 0)

    mock_repo.guardar.assert_not_called()
    mock_notif.enviar_confirmacion.assert_not_called()