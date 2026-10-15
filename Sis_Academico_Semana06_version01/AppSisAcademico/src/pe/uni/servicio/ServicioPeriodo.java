package pe.uni.servicio;

import java.util.ArrayList;
import java.util.List;
import pe.uni.dominio.Periodo;
import pe.uni.excepciones.ValidacionException;

public class ServicioPeriodo {

    private final List<Periodo> periodos = new ArrayList<>();

    public void registrarPeriodo(Periodo periodo) {
        if (periodo == null) {
            throw new ValidacionException("El período es obligatorio.");
        }

        for (Periodo registrado : periodos) {
            if (registrado.codigo().equals(periodo.codigo())) {
                throw new ValidacionException("Ya existe un período con el código " + periodo.codigo());
            }
        }

        periodos.add(periodo);
    }
    public Periodo buscarPorCodigo(String codigo) {
    for (Periodo periodo : periodos) {
        if (periodo.codigo().equals(codigo)) {
            return periodo;
        }
    }

    throw new ValidacionException("No existe un período con el código " + codigo);
}
}