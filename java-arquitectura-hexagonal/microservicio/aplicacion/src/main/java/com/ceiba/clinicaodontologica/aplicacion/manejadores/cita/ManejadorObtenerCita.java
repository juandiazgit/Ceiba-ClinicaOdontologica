package com.ceiba.clinicaodontologica.aplicacion.manejadores.cita;

import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.servicio.cita.ServicioObtenerCita;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.CitaEntity;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManejadorObtenerCita {

    private final ServicioObtenerCita servicioObtenerCita;

    public ManejadorObtenerCita(ServicioObtenerCita servicioObtenerProducto) {
        this.servicioObtenerCita = servicioObtenerProducto;
    }

    @Transactional
    public Cita ejecutar(int codigoPaciente) {
        return this.servicioObtenerCita.obtenerPorId(codigoPaciente);
    }
    
    public List<CitaEntity> obtenerListaDeCitas(int codigoDoctor) {
    	return this.servicioObtenerCita.obtenerListaDeCitas(codigoDoctor);
    }
}
