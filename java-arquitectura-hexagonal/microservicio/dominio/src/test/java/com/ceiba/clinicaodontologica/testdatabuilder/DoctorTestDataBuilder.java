package com.ceiba.clinicaodontologica.testdatabuilder;


import com.ceiba.clinicaodontologica.dominio.Doctor;

public class DoctorTestDataBuilder {
    
    private static final Integer CODIGO = 1010;
    private static final String NOMBRE = "Carlos";
    private static final String APELLIDO = "Torres";
    private static final String ESPECIALIZACION = "En Ortodoncia";

    private Integer codigo;
    private String nombre;
    private String apellido;
    private String especializacion;

    public DoctorTestDataBuilder() {
        this.codigo = CODIGO;
        this.nombre = NOMBRE;
        this.apellido = APELLIDO;
        this.especializacion = ESPECIALIZACION;
    }

    public DoctorTestDataBuilder conCodigo(Integer codigo) {
        this.codigo = codigo;
        return this;
    }

    public DoctorTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public DoctorTestDataBuilder conApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }

    public DoctorTestDataBuilder conEspecializacion(String especializacion) {
        this.especializacion = especializacion;
        return this;
    }

    public Doctor build() {
        return new Doctor(codigo, nombre, apellido, especializacion);
    }
}
