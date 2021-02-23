
package com.ceiba.clinicaodontologica.dominio.unitaria;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.testdatabuilder.CitaTestDataBuilder;

public class CitaTest {

    private static final String PROCEDIMIENTO = "Ortodoncia";
    private static final Date FECHACITA = new Date();

    @Test
    public void crearCitaTest() {

        // arrange
        CitaTestDataBuilder CitaTestDataBuilder = new CitaTestDataBuilder().
                conProcedimiento(PROCEDIMIENTO).
                conFechaCita(FECHACITA);

        // act
        Cita cita = CitaTestDataBuilder.build();

        // assert
        assertEquals(PROCEDIMIENTO, cita.getProcedimiento());
        assertEquals(FECHACITA, cita.getFechaCita());
    }

}

