package com.ceiba.clinicaodontologica.aplicacion.manejadores.cita;

import com.ceiba.clinicaodontologica.aplicacion.fabrica.FabricaCita;
import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.servicio.cita.ServicioCrearCita;
import com.ceiba.clinicaodontologica.aplicacion.comando.ComandoCita;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorCrearCita {

    private final ServicioCrearCita servicioCrearCita;
    private final FabricaCita fabricaCita;

    public ManejadorCrearCita(ServicioCrearCita servicioCrearCita, FabricaCita fabricaCita) {
        this.servicioCrearCita = servicioCrearCita;
        this.fabricaCita = fabricaCita;
    }

    @Transactional
    public void agregar(ComandoCita comandoCita) {
        Cita cita = this.fabricaCita.crearCita(comandoCita);
        this.servicioCrearCita.agregar(cita);
    }
}
