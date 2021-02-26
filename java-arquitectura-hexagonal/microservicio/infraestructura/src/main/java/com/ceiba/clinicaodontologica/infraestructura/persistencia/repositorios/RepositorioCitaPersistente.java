package com.ceiba.clinicaodontologica.infraestructura.persistencia.repositorios;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.excepcion.CitaException;
import com.ceiba.clinicaodontologica.dominio.excepcion.PacienteException;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.CitaEntity;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.jpa.RepositorioCitaJPA;
import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioCita;
import com.ceiba.clinicaodontologica.dominio.repositorio.RepositorioPaciente;
import com.ceiba.clinicaodontologica.infraestructura.configuracion.conexion.ConexionJPA;
import com.ceiba.clinicaodontologica.infraestructura.persistencia.builder.CitaBuilder;
import com.ceiba.clinicaodontologica.dominio.persistencia.repositorio.jpa.RepositorioCitaJPA;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.Date;
import java.util.List;

@Repository
public class RepositorioCitaPersistente implements RepositorioCita, RepositorioCitaJPA {

    private static final String CODIGO = "codigo";
    private static final String FECHA_CITA = "fechaCita";
    private static final String CITA_FIND_BY_CODIGO = "Cita.findByCodigo";
    private static final String CITAS_FIND_BY_CODIGO = "Citas.findByCodigo";
    private static final String CITA_UPDATE_BY_CODIGO = "Cita.UpdateByCodigo";
    private static final String UPDATE_CITA_OK = "Cita actualizada correctamente.";
    private static final String UPDATE_CITA_NO_OK = "La cita no pudo ser actualizada.";
    private static final String PACIENTE_NO_EXISTE = "El paciente no existe.";
    private static final String CITA_FIND_BY_CODIGO_DOC = "Cita.findByCodigoDoc";
    private static final String NO_CITAS_POR_FECHA = "No se puede asignar una cita a una misma fecha y hora ya registrada.";

    private final EntityManager entityManager = new ConexionJPA().createEntityManager();
    private RepositorioPaciente repositorioPacientePersistente;

    /*public RepositorioCitaPersistente(EntityManager entityManager, RepositorioPaciente repositorioPacientePersistente) {
    	
        this.entityManager = entityManager;
        this.repositorioPacientePersistente = repositorioPacientePersistente;
    }*/

    @Override
    public Cita obtenerPorId(int id) {

        Cita cita = obtenerCitaEntityPorCodigo(id);

        return cita;
    }

    @Override
    public void agregar(Cita cita) {
    	//Adicionar logica si el cliente existe.
    	Paciente paciente = repositorioPacientePersistente.obtenerPorId(cita.getPaciente().getCodigo());
    	
    	//Validar que el odontologo solo tenga una cita en una fecha y hora determinada. 
    	Cita citaResult = CitaBuilder.convertirADominio(obtenerCitaEntityPorCodigoDoc(cita.getDoctor().getCodigo(),cita.getFechaCita()));

    	if (citaResult != null) {
    		throw new CitaException(NO_CITAS_POR_FECHA);
		}
    	
    	if (paciente != null) {
        	//Validar si ya existe una cita para la misma fecha.
            entityManager.persist(CitaBuilder.convertirAEntity(cita));
		}else {
			throw new PacienteException(PACIENTE_NO_EXISTE);
		}        
    }
    
    @Override
    public void actualizar(Cita cita) {

        entityManager.merge(CitaBuilder.convertirAEntity(cita));
    }

    @Override
    public Cita obtenerCitaEntityPorCodigo(int codioPaciente) {

        Query query = entityManager.createNamedQuery(CITA_FIND_BY_CODIGO);
        query.setParameter(CODIGO, codioPaciente);

        List resultList = query.getResultList();

        return !resultList.isEmpty() ? CitaBuilder.convertirADominio((CitaEntity)resultList.get(0)) : null;
    }

	@Override
	public String actualizarCitaEntityPorCodigoPaciente(int codioPaciente, Date fechaCita) {
		
        Query query = entityManager.createNamedQuery(CITA_UPDATE_BY_CODIGO);
        query.setParameter(CODIGO, codioPaciente);
        query.setParameter(FECHA_CITA, fechaCita);

        return query.executeUpdate() == 1 ? UPDATE_CITA_OK : UPDATE_CITA_NO_OK;
	}

	@Override
	public List<CitaEntity> obtenerCitasEntityPorCodigoDoctor(int codioDoctor) {

        Query query = entityManager.createNamedQuery(CITAS_FIND_BY_CODIGO);
        query.setParameter(CODIGO, codioDoctor);

        List<CitaEntity> resultList = query.getResultList();
                
        return !resultList.isEmpty() ? resultList : null;
	}

	@Override
	public CitaEntity obtenerCitaEntityPorCodigoDoc(int codioDoctor, Date fechaCita) {
	
        Query query = entityManager.createNamedQuery(CITA_FIND_BY_CODIGO_DOC);
        query.setParameter(CODIGO, codioDoctor);
        query.setParameter(FECHA_CITA, fechaCita);

        List resultList = query.getResultList();

        return !resultList.isEmpty() ? (CitaEntity) resultList.get(0) : null;
	}

}
