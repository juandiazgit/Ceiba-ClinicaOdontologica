package com.ceiba.clinicaodontologica.infraestructura.persistencia.builder;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.Doctor;
import com.ceiba.clinicaodontologica.dominio.Factura;
import com.ceiba.clinicaodontologica.dominio.Paciente;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.CitaEntity;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.DoctorEntity;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.FacturaEntity;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.PacienteEntity;

public final class CitaBuilder{

	private CitaBuilder() {
	}

	public static Cita convertirADominio(CitaEntity citaEntity) {
		Cita cita = null;
		
		Paciente paciente = new Paciente(citaEntity.getPaciente().getCodigo(),
				citaEntity.getPaciente().getNombre(),
				citaEntity.getPaciente().getApellido(),
				citaEntity.getPaciente().getEdad(),
				citaEntity.getPaciente().getTelefono());
		
		Doctor doctor = new Doctor(citaEntity.getDoctor().getCodigo(),
				citaEntity.getDoctor().getNombre(),
				citaEntity.getDoctor().getApellido(),
				citaEntity.getDoctor().getEspecializacion());
		
		Factura factura = new Factura(citaEntity.getFactura().getFechaGeneracion(),
									  citaEntity.getFactura().getValorPagar());
		
		if (citaEntity != null) {
			cita = new Cita(citaEntity.getProcedimiento(),
							citaEntity.getFechaCita(), 
							paciente,
							doctor, 
							factura);
		}
		return cita;
	}

	public static CitaEntity convertirAEntity(Cita cita) {
		CitaEntity citaEntity = new CitaEntity();
		
		PacienteEntity pacienteEntity = new PacienteEntity(cita.getPaciente().getCodigo(),
										cita.getPaciente().getNombre(),
										cita.getPaciente().getApellido(),
										cita.getPaciente().getEdad(),
										cita.getPaciente().getTelefono());
		
		DoctorEntity doctorEntity = new DoctorEntity(cita.getDoctor().getCodigo(),
										cita.getDoctor().getNombre(),
										cita.getDoctor().getApellido(),
										cita.getDoctor().getEspecializacion());
		
		FacturaEntity facturaEntity = new FacturaEntity(cita.getFactura().getFechaGeneracion(),
									  cita.getFactura().getValorPagar());
		
		citaEntity.setProcedimiento(cita.getProcedimiento());
		citaEntity.setFechaCita(cita.getFechaCita());
		citaEntity.setPaciente(pacienteEntity);
		citaEntity.setDoctor(doctorEntity);
		citaEntity.setFactura(facturaEntity);
		return citaEntity;
	}
}
