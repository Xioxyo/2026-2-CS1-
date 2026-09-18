
package Descuentos;


public class DescuentoNavidad implements EstrategiaDescuento {
    @Override
    public double aplicar(double subtotal){
        return subtotal*0.8;
    }
    @Override
    public  String descripcion(){
        return "Navidad 20%";
    }
}