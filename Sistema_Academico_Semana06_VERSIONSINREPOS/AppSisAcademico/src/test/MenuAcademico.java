
package test;
import pe.uni.dominio.Alumno;
import pe.uni.dominio.Docente;
import pe.uni.dominio.Curso;
import pe.uni.dominio.Periodo;
import pe.uni.excepciones.ValidacionException;
import pe.uni.vista.VistaConsola;
import pe.uni.servicio.ServicioAlumno;
import pe.uni.servicio.ServicioDocente;
import pe.uni.servicio.ServicioCurso;
import pe.uni.servicio.ServicioPeriodo;
import pe.uni.servicio.ServicioMatricula;
import pe.uni.dominio.Matricula;
import java.util.List;

public class MenuAcademico {
    // la vista que muestra y lee los datos
    private final VistaConsola vista = new VistaConsola();
    
    // el servicio donde se registra y guarda
    private final ServicioAlumno servicioAlumno = new ServicioAlumno();
    private final ServicioDocente servicioDocente = new ServicioDocente();
    private final ServicioCurso servicioCurso = new ServicioCurso();
    private final ServicioPeriodo servicioPeriodo = new ServicioPeriodo();
    private final ServicioMatricula servicioMatricula = new ServicioMatricula(servicioAlumno,servicioDocente,servicioCurso,servicioPeriodo);
    
     public static void main(String[] args) {
        MenuAcademico programa = new MenuAcademico();
        programa.ejecutar();
    }

    public void ejecutar() {
        
        boolean continuar = true;

        while (continuar) {mostrarMenu();
    //leer la opcion del usuario
            int opcion = vista.leerEntero("Selecciona una opción: ");
            
        try {
               switch (opcion) {
               case 1:registrarAlumno();
               break;
                    
               case 2:registrarDocente();
               break;
               
               case 3:registrarCurso();
               break;
               
               case 4:registrarPeriodo();
               break;
               
               case 5:matricularAlumno();
               break;
               
               case 6:registrarNota();
               break;
               
               case 7:listarAlumnos();
               break;
               
               case 8:listarDocentes();
               break;
               
               case 9:listarCursos();
               break;
               
               case 10:listarMatriculasPorPeriodo();
               break;
               
               case 11:verHistorialAlumno();
               break;
               
               case 12:verPromedioMatricula();
               break;

               case 0:continuar = false;
               vista.mostrarMensaje("Programa finalizado.");
               break;
               
               default:
               vista.mostrarMensaje("La opción no existe.");
               break;
                }
            } catch (ValidacionException e) {
                vista.mostrarMensaje("Error: " + e.getMessage());
            }
        }
    }

    private void mostrarMenu() {
        vista.mostrarTitulo("SISTEMA ACADÉMICO");
        System.out.println("1.  Registrar alumno");
        System.out.println("2.  Registrar docente");
        System.out.println("3.  Registrar curso");
        System.out.println("4.  Registrar período");
        System.out.println("5.  Matricular alumno");
        System.out.println("6.  Registrar nota");
        System.out.println("7.  Listar alumnos");
        System.out.println("8.  Listar docentes");
        System.out.println("9.  Listar cursos");
        System.out.println("10. Listar matrículas por período");
        System.out.println("11. Ver historial de un alumno");
        System.out.println("12. Ver promedio de una matrícula");
        System.out.println("0.  Salir");
    }
//ALUMNO
    //pide los datos del alumno y su registro
    private void registrarAlumno() {
        vista.mostrarTitulo("REGISTRAR ALUMNO");
//se guardara cada respuesta
        String codigo = vista.leerTexto("Código: ");
        String nombres = vista.leerTexto("Nombres: ");
        String apellidos = vista.leerTexto("Apellidos: ");
        int edad = vista.leerEntero("Edad: ");
        String carrera = vista.leerTexto("Carrera: ");

        // se creara el alumno con los datos ingresados 
        Alumno alumno = new Alumno(codigo, nombres, apellidos, edad, carrera);

        servicioAlumno.registrarAlumno(alumno);

        vista.mostrarMensaje( "Alumno registrado correctamente: "+ alumno.nombreCompleto());
    }
  //DOCENTE  
    private void registrarDocente() {
    vista.mostrarTitulo("REGISTRAR DOCENTE");

    String codigo = vista.leerTexto("Código: ");
    String nombres = vista.leerTexto("Nombres: ");
    String apellidos = vista.leerTexto("Apellidos: ");
    String especialidad = vista.leerTexto("Especialidad: ");

    Docente docente = new Docente(codigo, nombres, apellidos, especialidad);
    // El servicio comprueba el código y guarda el docente
    servicioDocente.registrarDocente(docente);

    vista.mostrarMensaje("Docente registrado correctamente: " + docente.nombreCompleto());
    }
    
    //CURSO
    private void registrarCurso() {
    vista.mostrarTitulo("REGISTRAR CURSO");

    String codigo = vista.leerTexto("Código: ");
    String nombres = vista.leerTexto("Nombre del curso: ");
    int creditos = vista.leerEntero("Créditos: ");

    // Todo curso nuevo se registra 
    Curso curso = new Curso(codigo, nombres, creditos, true);

    // El servicio comprueba que el código no esté repetido.
    servicioCurso.registrarCurso(curso);

    vista.mostrarMensaje("Curso registrado correctamente: " + curso.nombres());
    }
    
    //periodo
    private void registrarPeriodo() {
    vista.mostrarTitulo("REGISTRAR PERÍODO");

    String codigo = vista.leerTexto("Código del período: ");
    String descripcion = vista.leerTexto("Descripción: ");

    Periodo periodo = new Periodo(codigo, descripcion);

    // El servicio verifica el código y guarda el período.
    servicioPeriodo.registrarPeriodo(periodo);
    vista.mostrarMensaje("Período registrado correctamente: " + periodo.codigo());
}
    private void matricularAlumno() {
    vista.mostrarTitulo("MATRICULAR ALUMNO");

    String codigoAlumno = vista.leerTexto("Código del alumno: ");
    String codigoPeriodo = vista.leerTexto("Código del período: ");
    String codigoCurso = vista.leerTexto("Código del curso: ");
    String codigoDocente = vista.leerTexto("Código del docente: ");

    servicioMatricula.matricularAlumno(codigoAlumno,codigoPeriodo,codigoCurso,codigoDocente);

    vista.mostrarMensaje("Matrícula registrada correctamente.");
    }
    //REGISTRAR NOTAS
    private void registrarNota() {
    vista.mostrarTitulo("REGISTRAR NOTA");

    String codigoAlumno = vista.leerTexto("Código del alumno: ");
    String codigoPeriodo = vista.leerTexto("Código del período: ");
    String codigoCurso = vista.leerTexto("Código del curso: ");
    int calificacion = vista.leerEntero("Calificación: ");

    servicioMatricula.registrarNota(codigoAlumno,codigoPeriodo,codigoCurso,calificacion);

    vista.mostrarMensaje("Nota registrada correctamente.");
    }
    
    //LISTAR ALUMNOS
    private void listarAlumnos() {
    vista.mostrarTitulo("ALUMNOS REGISTRADOS");

    List<Alumno> alumnos = servicioAlumno.listarAlumnos();

    if (alumnos.isEmpty()) {
        vista.mostrarMensaje("No hay alumnos registrados.");
        return;
    }

    for (Alumno alumno : alumnos) {
        vista.mostrarMensaje("Código: " + alumno.codigo()+ " | Nombre: " + alumno.nombreCompleto()+ " | Edad: " + alumno.edad()+ " | Carrera: " + alumno.carrera());
    }
}
    //LISTAR DOCENTES
    private void listarDocentes() {
    vista.mostrarTitulo("DOCENTES REGISTRADOS");

    List<Docente> docentes = servicioDocente.listarDocentes();

    if (docentes.isEmpty()) {
        vista.mostrarMensaje("No hay docentes registrados.");
        return;
    }

    for (Docente docente : docentes) {
        vista.mostrarMensaje("Código: " + docente.codigo()+ " | Nombre: " + docente.nombreCompleto()+ " | Especialidad: " + docente.especialidad());
    }
    }
    
    //listar cursos
    private void listarCursos() {
    vista.mostrarTitulo("CURSOS REGISTRADOS");

    List<Curso> cursos = servicioCurso.listarCursos();

    if (cursos.isEmpty()) {
        vista.mostrarMensaje("No hay cursos registrados.");
        return;
    }
    
    for (Curso curso : cursos) {
        String estado;
        if (curso.estado()) {
            estado = "ACTIVO";
        } else {
            estado = "INACTIVO";
        }

        vista.mostrarMensaje("Código: " + curso.codigo()+ " | Nombre: " + curso.nombres()+ " | Créditos: " + curso.creditos()+ " | Estado: " + estado);
    }
    }
    
    private void listarMatriculasPorPeriodo() {
    vista.mostrarTitulo("MATRÍCULAS POR PERÍODO");

    String codigoPeriodo = vista.leerTexto("Código del período: ");

    List<Matricula> matriculas = servicioMatricula.listarPorPeriodo(codigoPeriodo);

    if (matriculas.isEmpty()) {
        vista.mostrarMensaje("No hay matrículas para el período " + codigoPeriodo);
        return;
    }

    for (Matricula matricula : matriculas) {
        vista.mostrarMensaje("ID: " + matricula.idMatricula() + " | Alumno: " + matricula.NomApeAlumno() + " | Código alumno: " + matricula.codigoAlumno() + " | Curso: " + matricula.codigoCurso() + " | Docente: " + matricula.codigoDocente() + " | Período: " + matricula.codigoPeriodo() + " | Fecha: " + matricula.fechaMatricula() + " | Estado: " + matricula.estadoMatricula());
    }}
    
    private void verHistorialAlumno() {
    vista.mostrarTitulo("HISTORIAL DEL ALUMNO");

    String codigoAlumno = vista.leerTexto("Código del alumno: ");

    List<Matricula> historial = servicioMatricula.verHistorial(codigoAlumno);

    if (historial.isEmpty()) {
        vista.mostrarMensaje("El alumno no tiene matrículas registradas.");
        return;
    }

    for (Matricula matricula : historial) {
        vista.mostrarMensaje("ID: " + matricula.idMatricula() + " | Alumno: " + matricula.NomApeAlumno() + " | Período: " + matricula.codigoPeriodo() + " | Curso: " + matricula.codigoCurso() + " | Docente: " + matricula.codigoDocente() + " | Estado: " + matricula.estadoMatricula());
    }
    }
    
    private void verPromedioMatricula() {
    vista.mostrarTitulo("PROMEDIO DE UNA MATRÍCULA");

    String codigoAlumno = vista.leerTexto("Código del alumno: ");
    String codigoPeriodo = vista.leerTexto("Código del período: ");
    String codigoCurso = vista.leerTexto("Código del curso: ");

    double promedio = servicioMatricula.verPromedio(codigoAlumno, codigoPeriodo, codigoCurso);

    vista.mostrarMensaje(String.format("Promedio de la matrícula: %.2f", promedio));
}

   
    
    
    
    }
