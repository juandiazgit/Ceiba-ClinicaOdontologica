package com.ceiba.clinicaodontologica.dominio.servicio.cita;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.CitaEntity;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.jpa.RepositorioCitaJPA;
import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioCita;

@Service
public class ServicioObtenerCita {

    private final RepositorioCita repositorioCita;
    private final RepositorioCitaJPA repositorioCitaJPA;

    public ServicioObtenerCita(RepositorioCita repositorioCita, RepositorioCitaJPA repositorioCitaJPA) {
        this.repositorioCita = repositorioCita;
        this.repositorioCitaJPA = repositorioCitaJPA;
    }

    public Cita obtenerPorId(int codigoPaciente) {
        return this.repositorioCita.obtenerPorId(codigoPaciente);
    }
    
    public List<CitaEntity> obtenerListaDeCitas(int codigoDoctor) {
    	return this.repositorioCitaJPA.obtenerCitasEntityPorCodigoDoctor(codigoDoctor);
    }
}
