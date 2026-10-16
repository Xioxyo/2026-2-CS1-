
package com.mycompany.patronstrategy;


public class CalculoGeneral implements EstrategiaCalculoTributario{
    @Override
    public double calcular(double base){
        //se aplica impuesto de 18 y de 2
        return base*0.18*0.02;
    }
  
}
