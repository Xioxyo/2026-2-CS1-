
package clasesemana03;


public class PagoYape implements MetodoPago{
    @Override
    public void procesar(double monto){
        System.out.printf("Se pago con Yape el valor de" + monto + "soles");
    
    } 
}
