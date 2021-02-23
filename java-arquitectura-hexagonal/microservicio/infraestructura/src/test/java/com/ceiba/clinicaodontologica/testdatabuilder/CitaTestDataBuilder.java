
package com.ceiba.clinicaodontologica.testdatabuilder;

import java.util.Date;

import com.ceiba.clinicaodontologica.aplicacion.comando.ComandoCita;
import com.ceiba.clinicaodontologica.dominio.Cita;

public class CitaTestDataBuilder {

	private static final String PROCEDIMIENTO = "Ortodoncia";
	private static final Date FECHACITA = new Date();

	private String procedimiento;
	private Date fechaCita;

	public Cita build() {
		return new Cita(PROCEDIMIENTO, FECHACITA, new PacienteTestDataBuilder().build(),
				new DoctorTestDataBuilder().build(), new FacturaTestDataBuilder().build());
	}

	public CitaTestDataBuilder conProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
		return this;
	}

	public CitaTestDataBuilder conFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
		return this;
	}

	public ComandoCita buildComando() {
		return new ComandoCita(this.procedimiento, this.fechaCita, new PacienteTestDataBuilder().build(),
				new DoctorTestDataBuilder().build(), new FacturaTestDataBuilder().build());
	}
}
