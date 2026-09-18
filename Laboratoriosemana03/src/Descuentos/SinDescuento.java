
package Descuentos;

public class SinDescuento implements EstrategiaDescuento {
    @Override
    public double aplicar(double subtotal){
        return subtotal;
    }
    @Override
    public  String descripcion(){
        return "Vip 15%";
    }
}
