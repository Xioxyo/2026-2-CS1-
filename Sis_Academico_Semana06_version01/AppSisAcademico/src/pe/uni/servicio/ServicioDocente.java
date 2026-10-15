package pe.uni.servicio;

import java.util.ArrayList;
import java.util.List;
import pe.uni.dominio.Docente;
import pe.uni.excepciones.ValidacionException;

public class ServicioDocente {

    private final List<Docente> docentes = new ArrayList<>();

    public void registrarDocente(Docente docente) {
        if (docente == null) {
            throw new ValidacionException("El docente es obligatorio.");
        }

        for (Docente registrado : docentes) {
            if (registrado.codigo().equals(docente.codigo())) {
                throw new ValidacionException("Ya existe un docente con el código " + docente.codigo());
            }
        }

        docentes.add(docente);
    }
    public Docente buscarPorCodigo(String codigo) {
    for (Docente docente : docentes) {
        if (docente.codigo().equals(codigo)) {
            return docente;
        }
    }
    throw new ValidacionException("No existe un docente con el código " + codigo);
    }
}