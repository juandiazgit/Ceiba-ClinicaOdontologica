package com.ceiba.clinicaodontologica.aplicacion.comando;

import java.util.Date;

import com.ceiba.clinicaodontologica.dominio.Doctor;
import com.ceiba.clinicaodontologica.dominio.Factura;
import com.ceiba.clinicaodontologica.dominio.Paciente;

public class ComandoCita {

	private String procedimiento;

	private Date fechaCita;

	private Paciente paciente;

	private Doctor doctor;

	private Factura factura;

	public ComandoCita(String procedimiento, Date fechaCita, Paciente paciente, Doctor doctor,
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
