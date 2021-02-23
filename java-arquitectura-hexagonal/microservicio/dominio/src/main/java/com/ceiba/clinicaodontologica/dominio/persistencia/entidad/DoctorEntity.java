package com.ceiba.clinicaodontologica.dominio.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "Doctor")
@NamedQuery(name = "Doctor.findByCodigo", query = "SELECT doctor from Doctor doctor where doctor.doc_cod = :doc_cod")
public class DoctorEntity {

    @Id
    @Column(name = "doc_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "doc_cod")
    private Integer codigo;

    @Column(name = "doc_nom")
    private String nombre;
    
    @Column(name = "doc_apel")
    private String apellido;
    
    @Column(name = "doc_espec")
    private String especializacion;
    
    public DoctorEntity(Integer codigo, String nombre, String apellido, String especializacion) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especializacion = especializacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEspecializacion() {
		return especializacion;
	}

	public void setEspecializacion(String especializacion) {
		this.especializacion = especializacion;
	}

}
