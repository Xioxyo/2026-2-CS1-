
package pe.uni.servicio;
import java.util.ArrayList;
import java.util.List;
import pe.uni.dominio.Alumno;
import pe.uni.excepciones.ValidacionException;

public class ServicioAlumno {
    private final List<Alumno> alumnos = new ArrayList<>();

    public void registrarAlumno(Alumno alumno) {
        if (alumno == null) {
            throw new ValidacionException("El alumno es obligatorio.");
        }

        for (Alumno registrado : alumnos) {
            if (registrado.codigo().equals(alumno.codigo())) {
                throw new ValidacionException("Ya existe un alumno con el código " + alumno.codigo());
            }
        }

        alumnos.add(alumno);
    }   
    public Alumno buscarPorCodigo(String codigo) {
    for (Alumno alumno : alumnos) {
        if (alumno.codigo().equals(codigo)) {
            return alumno;
        }
    }
    throw new ValidacionException("No existe un alumno con el código " + codigo);
    }
    
    public List<Alumno> listarAlumnos() {
    // Devuelve una copia que no permite agregar ni eliminar elementos.
    return List.copyOf(alumnos);
}
}
