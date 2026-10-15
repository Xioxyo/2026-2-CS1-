
package pe.uni.vista;
import java.util.Scanner;

// scanner para que podamos ingresar datos, capturar las respuestas
public class VistaConsola {
    private final Scanner entrada = new Scanner(System.in);
    
    public void mostrarTitulo(String titulo) {
        System.out.println("\n=== " + titulo + " ===");
    }
// mostrar los resultados o errores    
    public void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }
//pedir y leer el texto, usa entrada.netxline que permite capturar el mensaje 
    //hasta presionar enter y el trim evita los espacios en blancos accidentales
    public String leerTexto(String mensaje){
        System.out.print(mensaje);
        return entrada.nextLine().trim();
    }
    
    // pedira un numero entero y se repetira si se escribe un valor incorrecto gracias al catch
    public int leerEntero(String mensaje){
        while(true){
            try{ return Integer.parseInt(leerTexto(mensaje));  
            }catch(NumberFormatException e){
                mostrarMensaje("Se debe ingresar un numero entero");
            }
        }
    }
    
}
