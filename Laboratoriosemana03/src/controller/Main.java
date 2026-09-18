
package controller;
import Pago.*;
import Descuentos.*;

public class Main {

    public static void main(String[] args) {
 Pedido pedido = new Pedido(
 new DescuentoBlackFriday(),
 new PagoYape()
 );
 pedido.procesar(200.0);
    }
    
}
