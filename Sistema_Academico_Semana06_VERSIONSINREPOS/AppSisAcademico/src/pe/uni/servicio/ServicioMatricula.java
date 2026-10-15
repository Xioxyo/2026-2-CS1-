package pe.uni.servicio;

import java.util.ArrayList;
import java.util.List;
import pe.uni.dominio.Alumno;
import pe.uni.dominio.Curso;
import pe.uni.dominio.Docente;
import pe.uni.dominio.Matricula;
import pe.uni.dominio.Periodo;
import pe.uni.excepciones.ValidacionException;

public class ServicioMatricula {

    private final List<Matricula> matriculas = new ArrayList<>();

    private final ServicioAlumno servicioAlumno;
    private final ServicioDocente servicioDocente;
    private final ServicioCurso servicioCurso;
    private final ServicioPeriodo servicioPeriodo;

    // Recibe los mismos servicios que utiliza el menu
    public ServicioMatricula(
            ServicioAlumno servicioAlumno,
            ServicioDocente servicioDocente,
            ServicioCurso servicioCurso,
            ServicioPeriodo servicioPeriodo) {

        this.servicioAlumno = servicioAlumno;
        this.servicioDocente = servicioDocente;
        this.servicioCurso = servicioCurso;
        this.servicioPeriodo = servicioPeriodo;
    }

    public void matricularAlumno(String codigoAlumno,String codigoPeriodo,String codigoCurso,String codigoDocente) {

        // Busca los objetos previamente registrados.
        Alumno alumno = servicioAlumno.buscarPorCodigo(codigoAlumno);
        Periodo periodo = servicioPeriodo.buscarPorCodigo(codigoPeriodo);
        Curso curso = servicioCurso.buscarPorCodigo(codigoCurso);
        Docente docente = servicioDocente.buscarPorCodigo(codigoDocente);

        if (!curso.estado()) {
            throw new ValidacionException("No se puede matricular en un curso inactivo.");
        }

        validarMatriculaDuplicada(codigoAlumno, codigoPeriodo, codigoCurso);

        // Respeta el orden de tu constructor de Matricula.
        Matricula matricula = new Matricula(alumno, periodo, curso, docente);

        matriculas.add(matricula);
    }

    private void validarMatriculaDuplicada(String codigoAlumno,String codigoPeriodo,String codigoCurso) {

        for (Matricula registrada : matriculas) {
            if (registrada.codigoAlumno().equals(codigoAlumno)
                    && registrada.codigoPeriodo().equals(codigoPeriodo)
                    && registrada.codigoCurso().equals(codigoCurso)) {

                throw new ValidacionException("El alumno ya tiene una matrícula "+ "en ese curso y período.");
            }
        }
    }
    
    private Matricula buscarMatricula(String codigoAlumno,String codigoPeriodo,String codigoCurso) {

    for (Matricula matricula : matriculas) {
        if (matricula.codigoAlumno().equals(codigoAlumno)&& matricula.codigoPeriodo().equals(codigoPeriodo)&& matricula.codigoCurso().equals(codigoCurso)) {
            return matricula;
        }
    }

    throw new ValidacionException("El alumno no tiene una matrícula en ese curso y período.");
    }
    public void registrarNota(String codigoAlumno,String codigoPeriodo,String codigoCurso,int calificacion) {
    Matricula matricula = buscarMatricula(codigoAlumno, codigoPeriodo, codigoCurso);
    matricula.registrarNota(calificacion);
    }
    
    public List<Matricula> listarPorPeriodo(String codigoPeriodo) {
    // Comprueba que el período esté registrado.
    servicioPeriodo.buscarPorCodigo(codigoPeriodo);

    List<Matricula> resultado = new ArrayList<>();

    // Selecciona las matrículas del período solicitado.
    for (Matricula matricula : matriculas) {
        if (matricula.codigoPeriodo().equals(codigoPeriodo)) {
            resultado.add(matricula);
        }
    }

    return List.copyOf(resultado);
    }
    public List<Matricula> verHistorial(String codigoAlumno) {
    // Comprueba que el alumno esté registrado.
    servicioAlumno.buscarPorCodigo(codigoAlumno);

    List<Matricula> resultado = new ArrayList<>();

    // Selecciona todas las matrículas de ese alumno.
    for (Matricula matricula : matriculas) {
        if (matricula.codigoAlumno().equals(codigoAlumno)) {
            resultado.add(matricula);
        }
    }

    return List.copyOf(resultado);}
    
    public double verPromedio(
        String codigoAlumno,
        String codigoPeriodo,
        String codigoCurso) {

    // Utiliza la búsqueda que agregamos al registrar notas.
    Matricula matricula = buscarMatricula(codigoAlumno, codigoPeriodo, codigoCurso);

    return matricula.promedio();
}
    
}