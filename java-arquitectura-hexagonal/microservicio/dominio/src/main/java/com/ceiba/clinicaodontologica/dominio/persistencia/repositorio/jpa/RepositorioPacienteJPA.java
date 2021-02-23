package com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.jpa;

import java.util.Date;
import java.util.List;

import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.CitaEntity;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.PacienteEntity;

public interface RepositorioPacienteJPA {

    /**
     * Permite obtener un paciente entity por un codigo de paciente
     *
     * @param codigoPaciente
     * @return
     */
	
    PacienteEntity obtenerPacienteEntityPorCodigo(int codioPaciente);

}
