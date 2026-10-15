
package pe.uni.dominio;
import pe.uni.excepciones.ValidacionException;

// el curso es independiente, solo registra cursos
//el mismo curso puede ser dictado por varios profesores
public record Curso (
    String codigo,
    String nombres,
    int creditos,
    boolean estado){ // true= curso activo, false = curso de baja
    public Curso{
        if(codigo == null || codigo.isBlank()){
            //throw new Valida
            throw new ValidacionException("El codigo del curso es obligatorio");
        }
        if(nombres == null || nombres.isBlank()){
            //throw new Valida
            throw new ValidacionException("El nombre del curso es obligatorio");
        }
        if(creditos <=0 ){
            //throw new Valida
            throw new ValidacionException("Los creditos deben poseer un valor mayor a 0");
        }

    }
}
