package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.AdquirirServicioProveedor;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AdquiriServicioRepoImpl implements IAdquiriServicioRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(AdquirirServicioProveedor adquirirServicioProveedor) {
		this.entityManager.persist(adquirirServicioProveedor);
	}

	@Override
	public List<AdquirirServicioProveedor> buscarTodos() {
		TypedQuery<AdquirirServicioProveedor> query=this.entityManager.createQuery("select c from AdquirirServicioProveedor c", AdquirirServicioProveedor.class);
		return query.getResultList();
	}

	@Override
	public void actualizar(AdquirirServicioProveedor adquirirServicioProveedor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(adquirirServicioProveedor);
	}

}
