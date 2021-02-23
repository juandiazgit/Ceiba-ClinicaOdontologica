package com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.jpa;

import java.util.Date;
import java.util.List;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.CitaEntity;

public interface RepositorioCitaJPA {

    /**
     * Permite obtener una cita entity por un codigo de paciente
     *
     * @param codigoPaciente
     * @return
     */
    Cita obtenerCitaEntityPorCodigo(int codioPaciente);

    /**
     * Permite obtener una cita entity por fecha de cita y codigo de doctor
     *
     * @param codigoPaciente
     * @return
     */
    CitaEntity obtenerCitaEntityPorCodigoDoc(int codioDoctor, Date fechaCita);    
    
    /**
     * Permite actualizar una cita dado un codigo de paciente
     *
     * @param codigoPaciente
     * @return
     */
    String actualizarCitaEntityPorCodigoPaciente(int codioPaciente, Date fechaCita);
    
    /**
     * Permite obtener una lista de citas dado un codigo de doctor
     *
     * @param codigoDoctor
     * @return
     */
    List<CitaEntity> obtenerCitasEntityPorCodigoDoctor(int codioDoctor);

}
