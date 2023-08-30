package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.citaHistorialClinico;
import com.example.demo.repository.IcitaHistorialClinicoRepository;

/**
 * Implementación del servicio para gestionar las citas de historial clínico.
 */
@Service
public class citaHistorialClinicoServiceImpl implements IcitaHistorialClinicoService {

	@Autowired
	private IcitaHistorialClinicoRepository clinicoRepository;

	/**
	 * Inserta una nueva cita de historial clínico y establece la fecha de la cita.
	 *
	 * @param citaHistorialClinico La cita de historial clínico a insertar.
	 */
	@Override
	public void insertar(citaHistorialClinico citaHistorialClinico) {
		citaHistorialClinico.setFechaCita(LocalDateTime.now());
		this.clinicoRepository.insertar(citaHistorialClinico);
	}

	/**
	 * Actualiza una cita de historial clínico existente.
	 *
	 * @param citaHistorialClinico La cita de historial clínico con los detalles actualizados.
	 */
	@Override
	public void actualizar(citaHistorialClinico citaHistorialClinico) {
		this.clinicoRepository.actualizar(citaHistorialClinico);
	}

	/**
	 * Busca y devuelve una lista de todas las citas de historial clínico.
	 *
	 * @return Una lista de todas las citas de historial clínico.
	 */
	@Override
	public List<citaHistorialClinico> buscarTodos() {
		return this.clinicoRepository.buscarTodos();
	}
}
