package com.ceiba.clinicaodontologica.infraestructura.persistencia.builder;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.CitaEntity;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.PacienteEntity;

public final class PacienteBuilder{

	private PacienteBuilder() {
	}

	public static Paciente convertirADominio(PacienteEntity pacienteEntity) {
		Paciente paciente = null;
		if (pacienteEntity != null) {
			paciente = new Paciente(pacienteEntity.getCodigo(),
									pacienteEntity.getNombre(),
							    	pacienteEntity.getApellido(), 
							    	pacienteEntity.getEdad(),
							    	pacienteEntity.getTelefono());
		}
		return paciente;
	}

	public static PacienteEntity convertirAEntity(Paciente paciente) {
		PacienteEntity pacienteEntity = new PacienteEntity();
		pacienteEntity.setCodigo(paciente.getCodigo());
		pacienteEntity.setNombre(paciente.getNombre());
		pacienteEntity.setApellido(paciente.getApellido());
		pacienteEntity.setEdad(paciente.getEdad());
		pacienteEntity.setTelefono(paciente.getTelefono());
		return pacienteEntity;
	}
}
