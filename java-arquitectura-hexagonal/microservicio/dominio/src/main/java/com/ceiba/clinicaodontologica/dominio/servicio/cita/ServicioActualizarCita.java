package com.ceiba.clinicaodontologica.dominio.servicio.cita;


import org.springframework.stereotype.Service;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioCita;

@Service
public class ServicioActualizarCita {

    private final RepositorioCita repositorioCita;

    public ServicioActualizarCita(RepositorioCita repositorioCita) {
        this.repositorioCita = repositorioCita;
    }

    public void actualizar(Cita cita) {
        this.repositorioCita.actualizar(cita);
    }
}
