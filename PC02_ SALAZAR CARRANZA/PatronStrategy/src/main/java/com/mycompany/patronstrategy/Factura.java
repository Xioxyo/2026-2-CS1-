
package com.mycompany.patronstrategy;


public class Factura {
    private EstrategiaCalculoTributario estrategia;

    public Factura(EstrategiaCalculoTributario estrategia) {
        this.estrategia = estrategia;
    }
    
    
    public double calcular(double base){
        return estrategia.calcular(base);
    }
}
