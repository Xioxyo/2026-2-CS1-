
package test;
import pe.uni.dominio.Alumno;
import pe.uni.dominio.Curso;
import pe.uni.dominio.Docente;
import pe.uni.dominio.Periodo;
import pe.uni.dominio.Matricula;
import pe.uni.dominio.Nota;


public class Main1 {
    
    
    // con lo avanzado implementar las iguientes funcionalidades:
    //
    public static void main(String[] args){
        Alumno alu1 = new Alumno("20244743G", "Astrid", "Salazar Carranza",20, "Ing. Software" );
        Docente doc1 = new Docente("iii", "Leandro", "Arias", "Matematico");
        Curso cur1 = new Curso("SW101", "Introduccion a la ING. Software", 3, true);
        Periodo per1 = new Periodo("2025-3", "Ciclo de vERNAO 2025-3, LLEVADOS EN VERANO DEL 2026");
        Matricula mat1 = new Matricula(alu1, per1, cur1,doc1);
        System.out.println("Datos del alumno");
        System.out.println("Nombres completos:" + alu1.nombreCompleto());
        System.out.println("Edad:" + alu1.edad());
        
        System.out.println("Datos del docente");
        System.out.println("Codigo :" + doc1.codigo());
        System.out.println("Nombres completos:" + doc1.nombreCompleto());

        System.out.println("Datos del curso");
        System.out.println("Codigo :" + cur1.codigo());
        System.out.println("Nombres completos:" + cur1.nombres());
        
        System.out.println("Datos del periodo:");
        System.out.println("Codigo: " + per1.codigo());
        System.out.println("Nombres completos: " + per1.descripcion());

        System.out.println("Datos de la matricula:");
        System.out.println("Id_matricula: " + mat1.idMatricula());
        System.out.println("Codigo Periodo: " + mat1.codigoPeriodo());
        System.out.println("Descripcion Periodo: " + mat1.descripcionPeriodo());
        System.out.println("Fecha matricula:" + mat1.fechaMatricula());
        System.out.println("Nombres y Apellidos del alumno: " + mat1.NomApeAlumno());
        System.out.println("Codido del curso: " + mat1.codigoCurso());
        System.out.println("Codigo Docente: " + mat1.codigoDocente());
        System.out.println("Estado de la Matricula: " + mat1.estadoMatricula());
        
        
        Nota not1 = new Nota(alu1, cur1, per1, 13);
        // por matricula, calificar curso
        mat1.agregarNota(not1);
        if(mat1.esAprobatoria()){
            System.out.println("Curso"+ mat1.codigoCurso()+ "APROBADO con " + not1.calificacion());
        }else{
            System.out.println("Curso"+ mat1.codigoCurso()+ "DESAPROBADO");

        }



        
        


}
}

