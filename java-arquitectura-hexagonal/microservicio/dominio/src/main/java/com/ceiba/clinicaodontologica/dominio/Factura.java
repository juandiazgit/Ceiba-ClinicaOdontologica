package com.ceiba.clinicaodontologica.dominio;

import java.util.Date;

public class Factura {

    private Date fechaGeneracion;
    private double valorPagar;
	
    public Factura(Date fechaGeneracion, double valorPagar) {
		this.fechaGeneracion = fechaGeneracion;
		this.valorPagar = valorPagar;
	}

	public Date getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(Date fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public double getValorPagar() {
		return valorPagar;
	}

	public void setValorPagar(double valorPagar) {
		this.valorPagar = valorPagar;
	}
    
}
