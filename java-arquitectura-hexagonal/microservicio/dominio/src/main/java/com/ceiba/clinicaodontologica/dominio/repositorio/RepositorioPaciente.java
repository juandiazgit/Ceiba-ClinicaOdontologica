package com.ceiba.clinicaodontologica.dominio.repositorio;


import com.ceiba.clinicaodontologica.dominio.Paciente;

public interface RepositorioPaciente {

    /**
     * Permite obtener un paciente dado su id
     *
     * @param id
     * @return Paciente
     */
    Paciente obtenerPorId(int id);

}