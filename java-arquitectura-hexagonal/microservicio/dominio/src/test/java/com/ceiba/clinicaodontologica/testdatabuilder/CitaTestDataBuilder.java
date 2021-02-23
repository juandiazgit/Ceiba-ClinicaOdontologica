
package com.ceiba.clinicaodontologica.testdatabuilder;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.DoctorEntity;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.FacturaEntity;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.PacienteEntity;

import java.util.Date;

public class CitaTestDataBuilder {
	
    private static final String PROCEDIMIENTO = "Ortodoncia";
    private static final Date FECHACITA = new Date();
    
	private String procedimiento;
	private Date fechaCita;

    public Cita build() {
        return new Cita(PROCEDIMIENTO,
        				FECHACITA,
        		        new PacienteTestDataBuilder().build(), 
        		        new DoctorTestDataBuilder().build(),
        		        new FacturaTestDataBuilder().build());
    }
    
    public CitaTestDataBuilder conProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
        return this;
    }

    public CitaTestDataBuilder conFechaCita(Date fechaCita) {
        this.fechaCita = fechaCita;
        return this;
    }
    
    
}

