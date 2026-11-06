import pytest

from calculadora import sumar, dividir, es_mayor_de_edad


# Prueba de Camino Normal
def test_sumar_positivos():
    assert sumar(2, 3) == 5


# Prueba de Valores Limites
def test_mayor_edad_limite_inferior():
    assert es_mayor_de_edad(18) is True


def test_menor_edad_limite_superior():
    assert es_mayor_de_edad(17) is False


# Prueba de manejo de excepciones
def test_dividir_por_cero():
    with pytest.raises(ValueError, match="No se puede dividir por cero"):
        dividir(10, 0)


# Prueba de entrada inválida
def test_edad_negativa():
    with pytest.raises(ValueError, match="La edad no puede ser negativa"):
        es_mayor_de_edad(-5)


# Prueba con multiples aserciones
@pytest.mark.parametrize("a, b, esperado", [
    (1, 1, 2),
    (-1, 1, 0),
    (0, 0, 0),
    (100, 200, 300),
])
def test_sumar_parametrizado(a, b, esperado):
    assert sumar(a, b) == esperado