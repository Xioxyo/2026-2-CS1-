package pe.uni.dominio;
import pe.uni.excepciones.ValidacionException;

public record Docente (
    String codigo, 
    String nombres,
    String apellidos,
    String especialidad){
    public Docente {// las validaciones
        if(codigo == null || codigo.isBlank()){
            //throw new Valida
            throw new ValidacionException("El codigo del docente es obligatorio");
        }
        if(nombres == null || nombres.isBlank()){
            //throw new Valida
            throw new ValidacionException("El nombre del docente es obligatorio");
        }
        if(apellidos == null || apellidos.isBlank()){
            //throw new Valida
            throw new ValidacionException("El apellido del docente es obligatorio");
        }
        if(especialidad == null || especialidad.isBlank()){
            //throw new Valida
            throw new ValidacionException("La especialidad del docente es obligatorio");
        }
    }
    // los record son inmutables porque no cambian
    public String nombreCompleto(){
        return nombres + " " + apellidos;
    }
}   
