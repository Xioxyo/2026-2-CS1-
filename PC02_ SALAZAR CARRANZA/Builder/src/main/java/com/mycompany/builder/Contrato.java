
package com.mycompany.builder;

public class Contrato {
    private final String codigo;
    private final String proveedor;
    private final double monto;
    private final int vigenciaDias;
    private final boolean ClausulaPenalidad;
    private final String observaciones;

    private Contrato(Builder builder) {
        this.codigo = builder.codigo;
        this.proveedor = builder.proveedor;
        this.monto = builder.monto;
        this.vigenciaDias = builder.vigenciaDias;
        this.ClausulaPenalidad = builder.ClausulaPenalidad;
        this.observaciones = builder.observaciones;
    }
    public static Builder builder() {
        return new Builder();
    }
    
    public static class Builder {

        private String codigo;
        private String proveedor;
        private double monto;
        private int vigenciaDias;
        private boolean ClausulaPenalidad;
        private String observaciones;

    
    public Builder codigo(String codigo) {
        this.codigo = codigo;
        return this;
    }
        public Builder proveedor(String proveedor) {
        this.codigo = proveedor;
        return this;
    }
    
    public Builder monto(double monto) {
        this.monto = monto;
        return this;
    }
    
    public Builder vigenciaDias(int vigenciasDias){
        this.vigenciaDias = vigenciaDias;
        return this;
    }
    public Builder ClausulaPenalidad(boolean ClausulaPenalidad){
        this.ClausulaPenalidad = ClausulaPenalidad;
        return this;
    }
    
    public Builder observaciones(String observaciones){
        this.observaciones = observaciones;
        return this;
    }
    
    public Contrato build(){
        
        if(codigo == null || codigo.isBlank()){
            throw new IllegalStateException("El codigo es obligatorio");
        }
        if(proveedor == null || proveedor.isBlank()){
            throw new IllegalStateException("El proveedor es obligatorio");
        }
        if( monto < 0){
            throw new IllegalStateException("El proveedor es obligatorio");
        }
        
        return new Contrato(this);
    }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public double getMonto() {
        return monto;
    }

    public int getVigenciaDias() {
        return vigenciaDias;
    }

    public boolean isClausulaPenalidad() {
        return ClausulaPenalidad;
    }

    public String getObservaciones() {
        return observaciones;
    }
    
    



    
    
    
    
}
