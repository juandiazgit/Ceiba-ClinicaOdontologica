package com.ceiba.clinicaodontologica.dominio.persistencia.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity(name = "Paciente")
@NamedQuery(name = "Paciente.findByCodigo", query = "SELECT paciente from Paciente paciente where paciente.pac_cod = :codigo")
public class PacienteEntity {

    @Id
    @Column(name = "pac_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "pac_cod")
    private Integer codigo;

    @Column(name = "pac_nom")
    private String nombre;
    
    @Column(name = "pac_apell")
    private String apellido;
    
    @Column(name = "pac_edad")
    private Integer edad;

    @Column(name = "pac_tel")
    private String telefono;

	public PacienteEntity() {}
    
    public PacienteEntity(Integer codigo, String nombre, String apellido, Integer edad, String telefono) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.telefono = telefono;
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

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
    
}
