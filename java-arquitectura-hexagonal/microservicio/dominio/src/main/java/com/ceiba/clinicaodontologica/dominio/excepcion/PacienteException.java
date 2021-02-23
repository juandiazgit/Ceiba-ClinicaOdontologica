package com.ceiba.clinicaodontologica.dominio.excepcion;

public class PacienteException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PacienteException(String message) {
        super(message);
    }
}
