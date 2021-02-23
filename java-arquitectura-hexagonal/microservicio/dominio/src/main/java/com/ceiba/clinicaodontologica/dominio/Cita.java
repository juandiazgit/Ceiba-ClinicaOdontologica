package com.ceiba.clinicaodontologica.dominio;

import java.util.Date;

import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.DoctorEntity;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.FacturaEntity;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.PacienteEntity;

public class Cita {

	private String procedimiento;
	private Date fechaCita;
	private Paciente paciente;
	private Doctor doctor;
	private Factura factura;

	public Cita(String procedimiento, Date fechaCita, Paciente paciente, Doctor doctor,
			    Factura factura) {
		this.procedimiento = procedimiento;
		this.fechaCita = fechaCita;
		this.paciente = paciente;
		this.doctor = doctor;
		this.factura = factura;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}
