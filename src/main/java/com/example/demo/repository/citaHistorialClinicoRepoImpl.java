package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.citaHistorialClinico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class citaHistorialClinicoRepoImpl implements IcitaHistorialClinicoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(citaHistorialClinico citaHistorialClinico) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citaHistorialClinico);
	}

	@Override
	public void actualizar(citaHistorialClinico citaHistorialClinico) {
		// TODO Auto-generated method stub
		this.entityManager.merge(citaHistorialClinico);
	}

	@Override
	public List<citaHistorialClinico> buscarTodos() {
		TypedQuery<citaHistorialClinico> myQuery = this.entityManager.createQuery("SELECT hc from citaHistorialClinico hc", citaHistorialClinico.class);
		return myQuery.getResultList();
	}

}
