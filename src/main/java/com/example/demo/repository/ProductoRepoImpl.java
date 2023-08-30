package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz de repositorio para la entidad Producto.
 */

@Transactional
@Repository
public class ProductoRepoImpl implements IProductoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Inserta un nuevo registro de Producto en la base de datos.
	 *
	 * @param producto El objeto Producto a insertar.
	 */
	@Override
	public void insertar(Producto producto) {
		this.entityManager.persist(producto);
	}

	/**
	 * Actualiza un registro de Producto en la base de datos.
	 *
	 * @param producto El objeto Producto con los detalles actualizados.
	 */
	@Override
	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);
	}

	/**
	 * Busca un registro de Producto por su código en la base de datos.
	 *
	 * @param codigo El código del Producto a buscar.
	 * @return El Producto encontrado, o null si no se encontró.
	 */
	@Override
	public Producto encontrar(String codigo) {
		TypedQuery<Producto> typedQuery = this.entityManager
				.createQuery("SELECT prod FROM Producto prod WHERE prod.codigo=:datoCodigo", Producto.class);
		typedQuery.setParameter("datoCodigo", codigo);
		try {
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Elimina un registro de Producto por su código de la base de datos.
	 *
	 * @param codigo El código del Producto a eliminar.
	 */
	@Override
	public void eliminar(String codigo) {
		this.entityManager.remove(this.encontrar(codigo));
	}

	/**
	 * Obtiene todos los registros de Producto de la base de datos.
	 *
	 * @return Una lista de todos los registros de Producto.
	 */
	@Override
	public List<Producto> encontrarTodos() {
		TypedQuery<Producto> query = this.entityManager.createQuery("SELECT prod FROM Producto prod", Producto.class);
		return query.getResultList();
	}

}

