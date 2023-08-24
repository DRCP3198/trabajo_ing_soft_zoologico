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
	public void actualizar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.merge(id);
	}

	@Override
	public Cliente encontrarUsuario(String usuario) {
		// TODO Auto-generated method stub

		TypedQuery<Cliente> typedQuery = this.entityManager
				.createQuery("SELECT cli FROM Cliente cli where cli.usuarioGeneral=:datoUsuario", Cliente.class);
		typedQuery.setParameter("datoUsuario", usuario);
		try {
			return typedQuery.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Usuario no encontrado");
			return null;
		}
	
	}
	// BUSCAR CEDULA
	@Override
	public Cliente encontrarCedula(String Cedula) {
		TypedQuery<Cliente> query = this.entityManager
				.createQuery("SELECT c FROM Cliente c WHERE c.cedula= :datoCedula", Cliente.class);
		query.setParameter("datoCedula", Cedula);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return query.getResultList().get(0);
		}
	}

	

	@Override
	public List<Cliente> encontrarTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> query = this.entityManager.createQuery("SELECT cli FROM Cliente cli", Cliente.class);
		return query.getResultList();
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cliente);
		
	}

	@Override
	public Cliente encontrarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Cliente.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.encontrarId(id));
		
	}

}
