
package laboratorio1;

public class Alumno {
    private int codigo;
    private int edad;
    private String nombres;
    public int creditosAprobados;
    int ciclo_relativo;
    int estado;

    public Alumno(int codigo, int edad, String nombres, int ciclo_relativo, int estado) {
        this.codigo = codigo;
        this.edad = edad;
        this.nombres = nombres;
        this.creditosAprobados=0;
        this.ciclo_relativo = ciclo_relativo;
        this.estado = estado;  } 

    public int getCodigo() {
        return codigo;
    } 

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getCiclo_relativo() {
        return ciclo_relativo;
    }

    public void setCiclo_relativo(int ciclo_relativo) {
        this.ciclo_relativo = ciclo_relativo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int calcularCicloRelativo() {
        if (creditosAprobados == 0)[
            return ;
        ]
// SEGUN NUMEROS DE CREDITOS LLEVALOS EL CICLO RELATIVO CAMBIA

    public void actualizarCreditos(int nuevosCreditos) {
        this.creditosAprobados += nuevosCreditos;
    }
//ACTUALIZAR CREDITOS LUEGO DE FINALIZAR UN CICLO CREO
            
}

