package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ProductoRepoImpl implements IProductoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Producto producto) {
		this.entityManager.persist(producto);
	}

	@Override
	public void actualizar(Producto producto) {
		this.entityManager.merge(producto);
	}

	@Override
	public Producto encontrar(String codigo) {
		TypedQuery<Producto> typedQuery = this.entityManager
				.createQuery("SELECT prod FROM Producto prod WHERE prod.codigo=:datoCodigo", Producto.class);
		typedQuery.setParameter("datoCodigo", codigo);
		return typedQuery.getSingleResult();
	}

	@Override
	public void eliminar(String codigo) {
		this.entityManager.remove(this.encontrar(codigo));
	}

	@Override
	public List<Producto> encontrarTodos() {
		TypedQuery<Producto> query = this.entityManager.createQuery("SELECT prod FROM Producto prod", Producto.class);
		return query.getResultList();
	}

}
