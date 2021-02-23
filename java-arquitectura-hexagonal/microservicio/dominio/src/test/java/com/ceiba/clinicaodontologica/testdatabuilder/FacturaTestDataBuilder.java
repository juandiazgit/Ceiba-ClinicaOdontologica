package com.ceiba.clinicaodontologica.testdatabuilder;


import java.util.Calendar;
import java.util.Date;

import com.ceiba.clinicaodontologica.dominio.Factura;

public class FacturaTestDataBuilder {
    
    private static final Date FECHAGENERACION = new Date();
    private static final double VALORPAGAR = 150000; 
    
    private Date fechaGeneracion;
    private double valorPagar;

    public FacturaTestDataBuilder() {
        this.fechaGeneracion = FECHAGENERACION;
        this.valorPagar = VALORPAGAR;
    }

    public FacturaTestDataBuilder conFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
        return this;
    }

    public FacturaTestDataBuilder conValorPagar(double valorPagar) {
        this.valorPagar = valorPagar;
        return this;
    }

    public Factura build() {
        return new Factura(fechaGeneracion, valorPagar);
    }
}
