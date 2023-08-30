package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.CompraProveedores;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CompraProveedoresRepoImpl implements ICompraProveedoresRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CompraProveedores compraProveedores) {
		// TODO Auto-generated method stub
		this.entityManager.persist(compraProveedores);
	}

	@Override
	public List<CompraProveedores> buscarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<CompraProveedores> query=this.entityManager.createQuery("select c from CompraProveedores c", CompraProveedores.class);
		return query.getResultList();
	}

	@Override
	public void actualizar(CompraProveedores compraProveedores) {
		// TODO Auto-generated method stub
		this.entityManager.merge(compraProveedores);
	}

}
