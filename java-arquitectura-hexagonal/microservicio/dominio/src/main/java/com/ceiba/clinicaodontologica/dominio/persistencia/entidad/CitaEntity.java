package com.ceiba.clinicaodontologica.dominio.persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity(name = "Cita")
@NamedQuery(name = "Cita.findByCodigo", query = "SELECT cita FROM Cita cita WHERE cita.paciente.pac_cod = :codigo")
@NamedQuery(name = "Citas.findByCodigo", query = "SELECT cita FROM Cita cita WHERE cita.doctor.doc_cod = :codigo")
@NamedQuery(name = "Cita.UpdateByCodigo", query = "UPDATE cita SET fechaCita = :fechaCita WHERE cita.cit_paccod = :codigo")
@NamedQuery(name = "Cita.findByCodigoDoc", query = "SELECT cita FROM Cita cita WHERE cita.doctor.doc_cod = :codigo and cita.cit_fecha = :fechaCita")
public class CitaEntity {

	@Id
	@Column(name = "cit_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	@Column(name = "cit_proced")
	private String procedimiento;
	
	@Column(name = "cit_fecha")
	private Date fechaCita;
	
	@ManyToOne
    @JoinColumn(name = "pac_cod", referencedColumnName = "cit_paccod")
    private PacienteEntity paciente;

    @ManyToOne
    @JoinColumn(name = "doc_cod", referencedColumnName = "cit_doccod")
    private DoctorEntity doctor;
    
    @ManyToOne
    @JoinColumn(name = "fac_id", referencedColumnName = "cit_fac_id")
    private FacturaEntity factura;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getProcedimiento() {
		return procedimiento;
	}

	public void setProcedimiento(String procedimiento) {
		this.procedimiento = procedimiento;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public PacienteEntity getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteEntity paciente) {
		this.paciente = paciente;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public FacturaEntity getFactura() {
		return factura;
	}

	public void setFactura(FacturaEntity factura) {
		this.factura = factura;
	}
    
}
