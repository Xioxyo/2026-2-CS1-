
package Descuentos;


public class DescuentoBlackFriday implements EstrategiaDescuento {
    @Override
    public double aplicar(double subtotal){
        return subtotal*0.7;
    }
    @Override
    public  String descripcion(){
        return "Black Friday 30%%";
    }
}
