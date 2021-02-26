package com.ceiba.clinicaodontologica.infraestructura.configuracion.sistema;

import javax.persistence.EntityManager;

import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioCita;
import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioPaciente;
import com.ceiba.clinicaodontologica.infraestructura.configuracion.conexion.ConexionJPA;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorios.RepositorioCitaPersistente;
//import com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorios.RepositorioPacientePersistente;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorios.RepositorioPacientePersistente;

public class SistemaDePersistencia {

    private final EntityManager entityManager;

    public SistemaDePersistencia() {
        this.entityManager = new ConexionJPA().createEntityManager();
    }

    public RepositorioPaciente obtenerRepositorioPacientes() {
        return new RepositorioPacientePersistente(entityManager);
    }
    
    /*public RepositorioCita obtenerRepositorioCitas() {
    	return new RepositorioCitaPersistente(entityManager, this.obtenerRepositorioPacientes());
    }*/

    public void iniciar() {
        entityManager.getTransaction().begin();
    }

    public void terminar() {
        entityManager.getTransaction().commit();
    }
}
