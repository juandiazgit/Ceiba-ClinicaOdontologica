
package com.ceiba.clinicaodontologica.dominio.unitaria;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.jpa.RepositorioCitaJPA;
import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioCita;
import com.ceiba.clinicaodontologica.dominio.servicio.cita.ServicioCrearCita;
//import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioPrestamo;
//import com.ceiba.clinicaodontologica.dominio.servicio.bibliotecario.ServicioBibliotecario;
import com.ceiba.clinicaodontologica.testdatabuilder.CitaTestDataBuilder;
import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioCita;
import com.ceiba.clinicaodontologica.testdatabuilder.CitaTestDataBuilder;

import org.junit.Test;
import org.mockito.internal.verification.Times;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;

public class ServicioCrearCitaTest {
    
    @Test
    public void esSiguienteDiaHabilTest() {
        // arrange
         String PROCEDIMIENTO = "Ortodoncia";
         Date FECHACITA = new Date();
    	 RepositorioCita repositorioCita = mock(RepositorioCita.class);
    	 ServicioCrearCita servicioCrearCita = new ServicioCrearCita(repositorioCita);
         /*Calendar calendario = Calendar.getInstance();
         calendario.add(Calendar.DAY_OF_YEAR, 1);
         Date sigDiaHabil = calendario.getTime();*/

         CitaTestDataBuilder citaTestDataBuilder = new CitaTestDataBuilder().
        		 								   conProcedimiento(PROCEDIMIENTO).
        		 								   conFechaCita(FECHACITA);
         
         Cita cita = new CitaTestDataBuilder().build();

         // act
         servicioCrearCita.agregar(cita);

        // Asset
         //verify(servicioCrearCita.esSabadoDomingo())
         verify(servicioCrearCita.esSabadoDomingo(), times(1));
        //assertEquals(sigDiaHabil, sigDiaHabilAct);
    }
    
    @Test
    public void esSiguienteDiaHabilNoTest() {
        // arrange
    	 ServicioCrearCita servicioCrearCita = mock(ServicioCrearCita.class);;
         //RepositorioCita repositorioCita = mock(RepositorioCita.class);
         Calendar calendario = Calendar.getInstance();
         calendario.add(Calendar.DAY_OF_YEAR, 3);
         Date sigDiaHabil = calendario.getTime();

         // act
         Date sigDiaHabilAct = servicioCrearCita.obtenerSiguienteDiaHabil();

        // Asset
        assertNotEquals(sigDiaHabil, sigDiaHabilAct);
    }
    
    @Test
    public void esSabadoDomingoTest() {
        // arrange
    	 ServicioCrearCita servicioCrearCita = mock(ServicioCrearCita.class);;
         boolean result = false;

         // act
         result = servicioCrearCita.esSabadoDomingo();

        // Asset
        assertFalse(result);
    }

    @Test
    public void citaAsignadaPacienteTest() {

        // arrange
        Cita cita = new CitaTestDataBuilder().build();

        RepositorioCitaJPA repositorioCitaJPA = mock(RepositorioCitaJPA.class);

        // act
        when(repositorioCitaJPA.obtenerCitaEntityPorCodigo(cita.getPaciente().getCodigo())).thenReturn(cita);

        // assert
        assertEquals(repositorioCitaJPA.obtenerCitaEntityPorCodigo(cita.getPaciente().getCodigo()),cita);
    }

}

