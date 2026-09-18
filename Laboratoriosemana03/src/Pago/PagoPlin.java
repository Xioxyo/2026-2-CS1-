
package Pago;

public class PagoPlin implements MetodoPago{
    @Override
    public void procesar(double monto){
        System.out.println("Cobrando S/ " + monto + " con plin");

    }
    @Override
    public String nombre(){ return "Plin";}
}

