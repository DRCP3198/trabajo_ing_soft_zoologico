package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Zoologico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz de repositorio para la entidad Zoologico.
 */

@Transactional
@Repository
public class ZoologicoRepoImpl implements IZoologicoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Inserta un nuevo registro de Zoologico en la base de datos.
	 *
	 * @param zoologico El objeto Zoologico a insertar.
	 */
	@Override
	public void insertar(Zoologico zoologico) {
		this.entityManager.persist(zoologico);
	}

}
