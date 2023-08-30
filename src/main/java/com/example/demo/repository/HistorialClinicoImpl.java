package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.HistorialClinico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz de repositorio para la entidad HistorialClinico.
 */

@Transactional
@Repository
public class HistorialClinicoImpl implements IHistorialClinicoRepo {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Inserta un nuevo registro de HistorialClinico en la base de datos.
	 *
	 * @param historialClinico El objeto HistorialClinico a insertar.
	 */
	@Override
	public void insertar(HistorialClinico historialClinico) {
		this.entityManager.persist(historialClinico);
	}

	/**
	 * Actualiza un registro de HistorialClinico en la base de datos.
	 *
	 * @param historialClinico El objeto HistorialClinico con los detalles actualizados.
	 */
	@Override
	public void actualizar(HistorialClinico historialClinico) {
		this.entityManager.merge(historialClinico);
	}

	/**
	 * Elimina un registro de HistorialClinico por su ID de la base de datos.
	 *
	 * @param id El ID del registro a eliminar.
	 */
	@Override
	public void eliminar(Integer id) {
		HistorialClinico hclin = this.seleccionar(id);
		this.entityManager.remove(hclin);
	}

	/**
	 * Busca un registro de HistorialClinico por su ID en la base de datos.
	 *
	 * @param id El ID del registro a buscar.
	 * @return El HistorialClinico encontrado.
	 */
	@Override
	public HistorialClinico seleccionar(Integer id) {
		return this.entityManager.find(HistorialClinico.class, id);
	}

	/**
	 * Obtiene todos los registros de HistorialClinico de la base de datos.
	 *
	 * @return Una lista de todos los registros de HistorialClinico.
	 */
	@Override
	public List<HistorialClinico> buscarTodos() {
		TypedQuery<HistorialClinico> myQuery = this.entityManager.createQuery(
			"SELECT hc FROM HistorialClinico hc", 
			HistorialClinico.class
		);
		return myQuery.getResultList();
	}
}

