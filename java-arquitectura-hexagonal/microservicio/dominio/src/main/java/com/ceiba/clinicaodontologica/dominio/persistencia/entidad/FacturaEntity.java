package com.ceiba.clinicaodontologica.dominio.persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "Factura")
@NamedQuery(name = "Factura.findById", query = "SELECT factura from Factura factura where doctor.fac_id = :fac_id")
public class FacturaEntity {

    @Id
    @Column(name = "fac_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fac_fecha")
    private Date fechaGeneracion;
   
    @Column(name = "fac_valor")
    private double valorPagar;
   
	public FacturaEntity(Date fechaGeneracion, double valorPagar) {
		this.fechaGeneracion = fechaGeneracion;
		this.valorPagar = valorPagar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
