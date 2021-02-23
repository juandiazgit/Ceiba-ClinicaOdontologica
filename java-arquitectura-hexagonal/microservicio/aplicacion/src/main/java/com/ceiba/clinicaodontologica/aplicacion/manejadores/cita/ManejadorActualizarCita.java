package com.ceiba.clinicaodontologica.aplicacion.manejadores.cita;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ceiba.clinicaodontologica.aplicacion.comando.ComandoCita;
import com.ceiba.clinicaodontologica.aplicacion.fabrica.FabricaCita;
import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.servicio.cita.ServicioActualizarCita;

@Component
public class ManejadorActualizarCita {

    private final ServicioActualizarCita servicioActualizarCita;
    private final FabricaCita fabricaCita;

    public ManejadorActualizarCita(ServicioActualizarCita servicioCrearCita, FabricaCita fabricaCita) {
        this.servicioActualizarCita = servicioCrearCita;
        this.fabricaCita = fabricaCita;
    }

    @Transactional
    public void actualizar(ComandoCita comandoCita) {
        Cita cita = this.fabricaCita.crearCita(comandoCita);
        this.servicioActualizarCita.actualizar(cita);
    }
}
