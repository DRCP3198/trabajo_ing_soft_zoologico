package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Servicio;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ServicioRepoImpl implements IServicioRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Servicio servicio) {
		this.entityManager.persist(servicio);
	}

	@Override
	public void actualizar(Servicio servicio) {
		this.entityManager.merge(servicio);
	}

	@Override
	public Servicio encontrar(String codigo) {
		TypedQuery<Servicio> typedQuery = this.entityManager
				.createQuery("SELECT serv FROM Servicio serv WHERE serv.codigo=:datoCodigo", Servicio.class);
		typedQuery.setParameter("datoCodigo", codigo);
		return typedQuery.getSingleResult();
	}

	@Override
	public void eliminar(String codigo) {
		this.entityManager.remove(this.encontrar(codigo));
	}

	@Override
	public List<Servicio> encontrarTodos() {
		TypedQuery<Servicio> query = this.entityManager.createQuery("SELECT serv FROM Servicio serv", Servicio.class);
		return query.getResultList();
	}

}
