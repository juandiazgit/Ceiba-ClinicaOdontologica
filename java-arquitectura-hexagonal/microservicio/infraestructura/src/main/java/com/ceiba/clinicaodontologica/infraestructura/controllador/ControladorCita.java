package com.ceiba.clinicaodontologica.infraestructura.controllador;

import com.ceiba.clinicaodontologica.aplicacion.comando.ComandoCita;
import com.ceiba.clinicaodontologica.aplicacion.manejadores.cita.ManejadorActualizarCita;
import com.ceiba.clinicaodontologica.aplicacion.manejadores.cita.ManejadorCrearCita;
import com.ceiba.clinicaodontologica.aplicacion.manejadores.cita.ManejadorObtenerCita;
import com.ceiba.clinicaodontologica.dominio.Cita;
import com.ceiba.clinicaodontologica.dominio.persistencia.entidad.CitaEntity;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cita")
public class ControladorCita {
	private final ManejadorCrearCita manejadorCrearCita;
	private final ManejadorObtenerCita manejadorObtenerCita;
	private final ManejadorActualizarCita manejadorActualizarCita;

	public ControladorCita(ManejadorCrearCita manejadorCrearCita, ManejadorObtenerCita manejadorObtenerCita,
			ManejadorActualizarCita manejadorActualizarCita) {
		this.manejadorCrearCita = manejadorCrearCita;
		this.manejadorObtenerCita = manejadorObtenerCita;
		this.manejadorActualizarCita = manejadorActualizarCita;
	}

	@GetMapping("/{codigoPaciente}")
	public Cita buscarCita(@PathVariable(name = "codigoPaciente") int codigoPaciente) {
		return this.manejadorObtenerCita.ejecutar(codigoPaciente);
	}

	@PostMapping
	public void asignarCita(@RequestBody ComandoCita comandoCita) {
		this.manejadorCrearCita.agregar(comandoCita);
	}

	@GetMapping("/{codigoDoctor}")
	public List<CitaEntity> listaCitas(@PathVariable(name = "codigoDoctor") int codigoDoctor) {
		return this.manejadorObtenerCita.obtenerListaDeCitas(codigoDoctor);
	}

	@PutMapping
	public void actualizar(@RequestBody ComandoCita comandoCita) {
		this.manejadorActualizarCita.actualizar(comandoCita);
	}

	/*@PostMapping("/{codigoPaciente}")
	public void realizarPagoFactura(@PathVariable(name = "codigoPaciente") int codigoPaciente) {
		this.manejadorHacerPago.agregar(codigoPaciente);
	}*/

}
