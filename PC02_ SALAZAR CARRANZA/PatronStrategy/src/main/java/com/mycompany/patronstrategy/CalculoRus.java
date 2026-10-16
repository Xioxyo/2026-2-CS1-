
package com.mycompany.patronstrategy;


public class CalculoRus implements EstrategiaCalculoTributario{
    @Override
    public double calcular(double base){
        //0 de impuesto, 0 de percepcion
        return base;
    }
    
}
