package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Proveedor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ProveedorRepoImpl implements IProveedorRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Proveedor proveedor) {
		this.entityManager.persist(proveedor);
	}

	@Override
	public void actualizar(Proveedor proveedor) {
		this.entityManager.merge(proveedor);
	}

	@Override
	public Proveedor encontrar(String codigo) {
		TypedQuery<Proveedor> typedQuery = this.entityManager
				.createQuery("SELECT prov FROM Proveedor prov WHERE prov.codigo=:datoCodigo", Proveedor.class);
		typedQuery.setParameter("datoCodigo", codigo);
		return typedQuery.getSingleResult();
	}

	@Override
	public void eliminar(String codigo) {
		this.entityManager.remove(this.encontrar(codigo));
	}

	@Override
	public List<Proveedor> encontrarTodos() {
		TypedQuery<Proveedor> query = this.entityManager.createQuery("SELECT prov FROM Proveedor prov", Proveedor.class);
		return query.getResultList();
	}

}
