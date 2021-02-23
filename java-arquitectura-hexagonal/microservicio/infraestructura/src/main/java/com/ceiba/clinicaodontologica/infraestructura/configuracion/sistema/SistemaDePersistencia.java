package com.ceiba.clinicaodontologica.infraestructura.configuracion.sistema;

import javax.persistence.EntityManager;

import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioCita;
import com.ceiba.clinicaodontologica.infraestructura.configuracion.conexion.ConexionJPA;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorios.RepositorioCitaPersistente;

public class SistemaDePersistencia {

    private final EntityManager entityManager;

    public SistemaDePersistencia() {
        this.entityManager = new ConexionJPA().createEntityManager();
    }

    public RepositorioCita obtenerRepositorioCitas() {
        return new RepositorioCitaPersistente(entityManager);
    }

    public void iniciar() {
        entityManager.getTransaction().begin();
    }

    public void terminar() {
        entityManager.getTransaction().commit();
    }
}
