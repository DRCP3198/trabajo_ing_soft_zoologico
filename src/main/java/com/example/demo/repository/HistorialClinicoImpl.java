package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.HistorialCitas;
import com.example.demo.modelo.HistorialClinico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HistorialClinicoImpl implements IHistorialClinicoRepo {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(HistorialClinico historialClinico) {
		this.entityManager.persist(historialClinico);
		
	}

	@Override
	public void actualizar(HistorialClinico historialClinico) {
		this.entityManager.merge(historialClinico);
		
	}

	@Override
	public void eliminar(Integer id) {
		HistorialClinico hclin= this.seleccionar(id);
		this.entityManager.remove(hclin);
		
		
	}

	@Override
	public HistorialClinico seleccionar(Integer id) {
		return this.entityManager.find(HistorialClinico.class, id);
	}

	@Override
	public List<HistorialClinico> buscarTodos() {
		TypedQuery<HistorialClinico> myQuery = this.entityManager.createQuery("SELECT hc from HistorialClinico hc", HistorialClinico.class);
		return myQuery.getResultList();
	}

	
}
