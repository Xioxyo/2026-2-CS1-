
package com.mycompany.patronstrategy;


public class PatronStrategy {

    public static void main(String[] args) {
       double base = 1000;
       
       System.out.println("Calculadora de la SUNAT para calcular el impuesto");
       Factura calculadora = new Factura(new CalculoRer());
       System.out.println("El impuesto es "+ calculadora.calcular(base));
    }
}
