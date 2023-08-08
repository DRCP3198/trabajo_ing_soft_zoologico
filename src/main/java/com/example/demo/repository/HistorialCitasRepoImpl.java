package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.HistorialCitas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class HistorialCitasRepoImpl implements IHistorialCitasRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(HistorialCitas citas) {
		// TODO Auto-generated method stub
		this.entityManager.persist(citas);

	}

	@Override
	public List<HistorialCitas> buscar(String fechaIngreso) {
		// TODO Auto-generated method stub

		TypedQuery<HistorialCitas> typedQuery = this.entityManager
				.createQuery("SELECT hc from HistorialCitas hc WHERE hc.fechaIngreso=:datoFechaIngreso", HistorialCitas.class);
		typedQuery.setParameter("datoFechaIngreso", fechaIngreso);
		return typedQuery.getResultList();
	}

}
