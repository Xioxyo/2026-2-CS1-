
package clasesemana03;


public class PagoTarjeta implements MetodoPago {
    @Override
    public void procesar(double monto){
        System.out.printf("Se pago con Tarejta el valor de " + monto + " soles\n");
    
    }
}
