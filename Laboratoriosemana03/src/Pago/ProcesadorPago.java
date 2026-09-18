
package Pago;

//efectua el pago sin importar el tipo de pago
public class ProcesadorPago {
    public void cobrar(MetodoPago metodo, double monto) {
 metodo.procesar(monto);
}

}
