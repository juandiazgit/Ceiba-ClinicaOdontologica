package com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.PacienteEntity;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.jpa.RepositorioPacienteJPA;
import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioPaciente;
import com.ceiba.clinicaodontologica.infraestructura.configuracion.sistema.SistemaDePersistencia;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.builder.PacienteBuilder;

@Repository
public class RepositorioPacientePersistente implements RepositorioPaciente, RepositorioPacienteJPA {

    private static final String CODIGO = "codigo";
    private static final String CITA_FIND_BY_CODIGO = "Paciente.findByCodigo";

    private EntityManager entityManager;

    public RepositorioPacientePersistente(EntityManager entityManager){
    	
    	this.entityManager = entityManager;
    }

    @Override
    public Paciente obtenerPorId(int id) {

        PacienteEntity pacienteEntity = obtenerPacienteEntityPorCodigo(id);

        return PacienteBuilder.convertirADominio(pacienteEntity);
    }

    @Override
    public PacienteEntity obtenerPacienteEntityPorCodigo(int codioPaciente) {

        Query query = entityManager.createNamedQuery(CITA_FIND_BY_CODIGO);
        query.setParameter(CODIGO, codioPaciente);

        List resultList = query.getResultList();

        return !resultList.isEmpty() ? (PacienteEntity) resultList.get(0) : null;
    }

}
