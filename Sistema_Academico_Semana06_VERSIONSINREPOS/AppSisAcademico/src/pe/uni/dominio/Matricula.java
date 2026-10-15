package pe.uni.dominio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import pe.uni.excepciones.ValidacionException;
public class Matricula{
    private int id_matricula;
    private static int contador_matricula = 0;
    private Alumno alumno;
    private Periodo periodo;
    private Curso curso;
    private Docente docente;
    private LocalDate fecha;
    private  EstadoMatricula estado;
    private List<Nota> notas = new ArrayList<>();

    public Matricula(Alumno alumno, Periodo periodo, Curso curso, Docente docente) {
       if(alumno.codigo() == null || alumno.codigo().isBlank()){
           throw new ValidacionException("El codigo del alumno es obligatorio"); 
       }
        if(periodo.codigo() == null || periodo.codigo().isBlank()){
           throw new ValidacionException("El periodo del alumno es obligatorio"); 
       }
 
        //Entra en bruto los valores ya validados
        contador_matricula++; // esto es para tener el ultimo valor del autocorrelativo
        //nueva matricula => aumenta el contador
        this.id_matricula = contador_matricula; // asignar el valor del contador
        this.alumno = alumno;
        this.periodo = periodo;
        this.curso = curso;
        this.docente = docente;
        this.fecha = LocalDate.now();
        this.estado = EstadoMatricula.ACTIVA;
        // puedes haber un estado de matriculado retirado, anulado, cancelado, ..
        //deberia haber un estado de matricula con varios estados
    }
    // CONSULTAS ( Son los query) 
    //devuelve info
    public int idMatricula(){
        return id_matricula;
    }
    public String codigoAlumno(){
        return alumno.codigo();
    }
    public String NomApeAlumno(){
        return alumno.nombreCompleto();
    }
    public String codigoCurso(){
        return curso.codigo();
    }
    public String codigoDocente(){
        return docente.codigo();
    }
    public String codigoPeriodo(){
        return periodo.codigo();
    }
    public String descripcionPeriodo(){
        return periodo.descripcion();
    }
    public String estadoMatricula(){
        switch(estado){
            case ACTIVA: return "ACTIVA";
            case CANCELADA: return "ACTIVA";
            case ANULADA: return "ANULADA";
            case NO_MATRICULADO: return "NO MATRICULADO";
            case RETIRADA: return "RETIRADO";  
        }
        return ""; // aqui nunca se deberia llegar
    }
    public LocalDate fechaMatricula(){
        return fecha;
    }

    // enves de que apruebe con solo una nota, se considera
    //el promedio aprobado
    public boolean esAprobatoria(){
        return promedio()>= 10;
    }
    
  //COMANDS
//devuelve comandos
  
    public void RetirarAlumno(){
    if(estado != EstadoMatricula.ACTIVA){
        throw new ValidacionException("Solo se puede retirar una matricula activa");
    }
    
    this.estado = EstadoMatricula.RETIRADA;}
    
    
    public void agregarNota(Nota nota){
        if(!estado.permiteCalificaciones()){// si no permite calificaciones, salir de la funciona con una l
            throw new ValidacionException("No se puede agregar notas a una matricula con un estado" + estado);
       
        }
        notas.add(nota); //agregar nota 
    }
    
    public void AnularMatricula(){
        if(estado != EstadoMatricula.ACTIVA){
            throw new ValidacionException("Solo se puede anular matriculado activa");
        }
         this.estado = EstadoMatricula.ANULADA;
    }
    // nueva funcionalidad: promedio, usamos empty debido a que notas es lista.
    public double promedio(){
        if(notas.isEmpty()){
            throw new ValidacionException("La matricula no cuenta con notas");
        }
        
        double suma = 0;
        
        for( Nota nota : notas){
            suma += nota.calificacion();
        }
        return suma/notas.size();
        //sumar calificaciones y dividir entre cantidad de notas
    }
    
    public void registrarNota(int calificacion) {
    // Crea la nota con los datos de esta matrícula.
    Nota nota = new Nota(alumno, curso, periodo, calificacion);

    // Comprueba el estado de la matrícula y añade la nota a su lista.
    agregarNota(nota);
}

}


// la matricula no sera un record, es una entidad compuesta de otras
// no va a ser como una entidad que se registra directamente
//razonamiento del profe
//los docentes pueden tener varios cursos
//esto se pone en la matricula

