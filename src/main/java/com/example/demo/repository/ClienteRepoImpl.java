package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ClienteRepoImpl implements IClienteRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
	}

	@Override
	public Cliente encontrar(String cedula) {
		// TODO Auto-generated method stub

		TypedQuery<Cliente> typedQuery = this.entityManager
				.createQuery("SELECT cli FROM Cliente cli where cli.cedula=:datoCedula", Cliente.class);
		typedQuery.setParameter("datoCedula", cedula);
		return typedQuery.getSingleResult();
	}

	@Override
	public void eliminar(String cedula) {
		// TODO Auto-generated method stub
		
		this.entityManager.remove(this.encontrar(cedula));

	}

	@Override
	public List<Cliente> encontrarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = this.entityManager.createQuery("SELECT cli FROM Cliente cli", Cliente.class);
		return query.getResultList();
	}

}
