
package pe.uni.dominio;
import pe.uni.excepciones.ValidacionException;

// es un registro
public record Nota(
  Alumno alumno,
  Curso curso,
  Periodo periodo,
  int calificacion  ) {
    public Nota{
        if( calificacion < 0 || calificacion >20){
            throw new ValidacionException("La calificacion debe estar entre 0 y 20");
        }
    }
    public boolean esAprobatoria(){
        return calificacion >= 10;
    }
    public int getcalificacion(){
        return calificacion;
    }
}
