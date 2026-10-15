
package pe.uni.dominio;
import pe.uni.excepciones.ValidacionException;

public record Alumno( // estructura para fegistrar los datos
    String codigo, // losatributos (usamos , enves de ;)
    String nombres,
    String apellidos,
    int edad,
    String carrera) {
    public Alumno{
        if(codigo == null || codigo.isBlank()){
            //throw new Valida
            throw new ValidacionException("El codigo del alumno es obligatorio");
        }
        if(nombres == null || nombres.isBlank()){
            //throw new Valida
            throw new ValidacionException("El nombre del alumno es obligatorio");
        }
        if(apellidos == null || apellidos.isBlank()){
            //throw new Valida
            throw new ValidacionException("El apellido del alumno es obligatorio");
        }
        if(edad < 15 || edad > 100){
            //throw new Valida
            throw new ValidacionException("La edad del alumno debe estar entre 15 y 100 anos");
        }
        if(carrera == null || carrera.isBlank()){
            //throw new Valida
            throw new ValidacionException("La carrera del alumno es obligatorio");
        }
    }
    
    public String nombreCompleto(){
        return nombres + " " + apellidos;
    }
}
