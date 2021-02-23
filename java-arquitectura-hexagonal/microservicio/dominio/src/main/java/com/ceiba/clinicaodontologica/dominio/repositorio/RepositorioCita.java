package com.ceiba.clinicaodontologica.dominio.repositorio;


import com.ceiba.clinicaodontologica.dominio.Cita;

public interface RepositorioCita {

    /**
     * Permite obtener una cita dado su id
     *
     * @param id
     * @return Cita
     */
    Cita obtenerPorId(int id);

    /**
     * Permite agregar una cita al repositorio
     *
     * @param cita
     */
    void agregar(Cita cita);
    
    /**
     * Permite actualizar una cita al repositorio
     *
     * @param cita
     */
    void actualizar(Cita cita);

}