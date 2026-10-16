
package com.mycompany.patronstrategy;


public class CalculoRer implements EstrategiaCalculoTributario {
    @Override
    public double calcular(double base){
        // 18 de impuesto 
        return base*0.18;
    }
}
