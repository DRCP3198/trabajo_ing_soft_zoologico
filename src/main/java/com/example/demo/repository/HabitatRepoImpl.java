package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Habitat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HabitatRepoImpl implements IHabitatRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Habitat habitat) {
		// TODO Auto-generated method stub
		this.entityManager.persist(habitat);
	}

	@Override
	public void actualizar(Habitat habitat) {
		// TODO Auto-generated method stub
		this.entityManager.merge(habitat);
	}

	@Override
	public Habitat buscar(String tipo) {
		// TODO Auto-generated method stub
		TypedQuery<Habitat> typedQuery = this.entityManager
				.createQuery("SELECT h from Habitat h WHERE h.tipo=:datoTipo", Habitat.class);
       typedQuery.setParameter("datoTipo", tipo);
		return typedQuery.getSingleResult();
	}

	@Override
	public void eliminar(String tipo) {
		// TODO Auto-generated method stub
		
		this.entityManager.remove(this.buscar(tipo));

	}

}
