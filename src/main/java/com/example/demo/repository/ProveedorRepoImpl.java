package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Proveedor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz de repositorio para la entidad Provedor.
 */

@Transactional
@Repository
public class ProveedorRepoImpl implements IProveedorRepo {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Inserta un nuevo registro de Proveedor en la base de datos.
	 *
	 * @param proveedor El objeto Proveedor a insertar.
	 */
	@Override
	public void insertar(Proveedor proveedor) {
		this.entityManager.persist(proveedor);
	}

	/**
	 * Actualiza un registro de Proveedor en la base de datos.
	 *
	 * @param proveedor El objeto Proveedor con los detalles actualizados.
	 */
	@Override
	public void actualizar(Proveedor proveedor) {
		this.entityManager.merge(proveedor);
	}

	/**
	 * Busca un registro de Proveedor por su código en la base de datos.
	 *
	 * @param codigo El código del Proveedor a buscar.
	 * @return El Proveedor encontrado.
	 */
	@Override
	public Proveedor encontrar(String codigo) {
		TypedQuery<Proveedor> typedQuery = this.entityManager
				.createQuery("SELECT prov FROM Proveedor prov WHERE prov.codigo=:datoCodigo", Proveedor.class);
		typedQuery.setParameter("datoCodigo", codigo);
		return typedQuery.getSingleResult();
	}

	/**
	 * Elimina un registro de Proveedor por su código de la base de datos.
	 *
	 * @param codigo El código del Proveedor a eliminar.
	 */
	@Override
	public void eliminar(String codigo) {
		this.entityManager.remove(this.encontrar(codigo));
	}

	/**
	 * Obtiene todos los registros de Proveedor de la base de datos.
	 *
	 * @return Una lista de todos los registros de Proveedor.
	 */
	@Override
	public List<Proveedor> encontrarTodos() {
		TypedQuery<Proveedor> query = this.entityManager.createQuery("SELECT prov FROM Proveedor prov", Proveedor.class);
		return query.getResultList();
	}

}

