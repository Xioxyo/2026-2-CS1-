package pe.uni.servicio;

import java.util.ArrayList;
import java.util.List;
import pe.uni.dominio.Curso;
import pe.uni.excepciones.ValidacionException;

public class ServicioCurso {

    private final List<Curso> cursos = new ArrayList<>();

    public void registrarCurso(Curso curso) {
        if (curso == null) {
            throw new ValidacionException("El curso es obligatorio.");
        }

        for (Curso registrado : cursos) {
            if (registrado.codigo().equals(curso.codigo())) {
                throw new ValidacionException("Ya existe un curso con el código " + curso.codigo());
            }
        }

        cursos.add(curso);
    }
    public Curso buscarPorCodigo(String codigo) {
    for (Curso curso : cursos) {
        if (curso.codigo().equals(codigo)) {
            return curso;
        }
    }

    throw new ValidacionException("No existe un curso con el código " + codigo);
    }
}