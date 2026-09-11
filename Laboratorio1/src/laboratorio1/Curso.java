
package laboratorio1;
public class Curso {
   public int codigo;
   public String nombreCurso;
   public int numeroCreditos;
   
   public Curso(int codigo, String nombreCurso, int numeroCreditos){
       this.codigo = codigo;
       this nombreCurso = nombreCurso;
   }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }  
}