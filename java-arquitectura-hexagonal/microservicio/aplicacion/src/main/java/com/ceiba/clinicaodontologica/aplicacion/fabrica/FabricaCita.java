package com.ceiba.clinicaodontologica.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.clinicaodontologica.aplicacion.comando.ComandoCita;
import com.ceiba.clinicaodontologica.dominio.Cita;

@Component
public class FabricaCita {
	
    public Cita crearCita(ComandoCita comandoCita) {
        
    	return new Cita(comandoCita.getProcedimiento(),
		    			comandoCita.getFechaCita(),
		    			comandoCita.getPaciente(),
		    			comandoCita.getDoctor(),
		    			comandoCita.getFactura());
    }
}
