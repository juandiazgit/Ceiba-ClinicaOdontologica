package com.ceiba.clinicaodontologica.dominio.servicio.cita;


import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.excepcion.CitaException;
import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioCita;

@Service
public class ServicioCrearCita {

	private final RepositorioCita repositorioCita;
	
    private static final String NO_ASIGNACION_SABADO_DOMINGO = "Los sabados y domingos no se pueden asignar citas";

    public ServicioCrearCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public void agregar(Cita cita) {
    	
    	if(esSabadoDomingo()) {
    		throw new CitaException(NO_ASIGNACION_SABADO_DOMINGO);
    	}
    	
    	//Asignar siguiente dia habil
    	cita.setFechaCita(obtenerSiguienteDiaHabil());
    	
        this.repositorioCita.agregar(cita);
    }
    
	public Date obtenerSiguienteDiaHabil() {
		
		Calendar calendario;
	    boolean diaSigHabil = false;
	    int diaSumado = 1;
	     
		calendario = Calendar.getInstance();
	      
	    while (!diaSigHabil) {
	          
	    	calendario.add(Calendar.DAY_OF_YEAR, diaSumado);
	          
	        if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || 
	        	calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
	        	continue;
	        }else{
	        	diaSigHabil = true;
	        }
	    }
	    
	    return calendario.getTime();
	}
	
	public boolean esSabadoDomingo() {
		
		Calendar calendario = Calendar.getInstance();

		if (calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || 
		    calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
			return true;
		}
		return false;
	}
}
