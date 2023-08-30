package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Zoologico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ZoologicoRepoImpl implements IZoologicoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Zoologico zoologico) {
		// TODO Auto-generated method stub
		this.entityManager.persist(zoologico);

	}

}
