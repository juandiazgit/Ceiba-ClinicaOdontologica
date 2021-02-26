package com.ceiba.clinicaodontologica.testdatabuilder;


import com.ceiba.clinicaodontologica.dominio.Paciente;

public class PacienteTestDataBuilder {
    
    private static final Integer CODIGO = 1010;
    private static final String NOMBRE = "Juan";
    private static final String APELLIDO = "Diaz";
    private static final Integer EDAD = 30;
    private static final String TELEFONO = "345665";

    private Integer codigo;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String telefono;

    public PacienteTestDataBuilder() {
        this.codigo = CODIGO;
        this.nombre = NOMBRE;
        this.apellido = APELLIDO;
        this.edad = EDAD;
        this.telefono = TELEFONO;
    }

    public PacienteTestDataBuilder conCodigo(Integer codigo) {
        this.codigo = codigo;
        return this;
    }

    public PacienteTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PacienteTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public PacienteTestDataBuilder conEdad(Integer edad) {
        this.edad = edad;
        return this;
    }
    
    public PacienteTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public Paciente build() {
        return new Paciente(codigo, nombre, apellido, edad, telefono);
    }
}
