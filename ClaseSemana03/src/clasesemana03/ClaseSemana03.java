
package clasesemana03;

public class ClaseSemana03 {

 
    public static void main(String[] args) {
     MetodoPago pago1 = new PagoYape();
     MetodoPago pago2 = new PagoTarjeta();
     
     
     pago1.procesar(1500.0);
     
     
     pago2.procesar(12.0);     
    
    
}
}