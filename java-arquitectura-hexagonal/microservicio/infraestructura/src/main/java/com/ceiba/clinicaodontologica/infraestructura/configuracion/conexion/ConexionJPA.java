package com.ceiba.clinicaodontologica.infraestructura.configuracion.conexion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionJPA {

    private static final String CLINICA_ODONTOLOGICA = "test";

    private static EntityManagerFactory entityManagerFactory;

    public ConexionJPA() {
        Persistence.createEntityManagerFactory(CLINICA_ODONTOLOGICA);
    }

    public EntityManager createEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
