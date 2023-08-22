package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class UsuarioRepoImpl implements IUsuarioRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Usuario usuario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(usuario);
	}

	@Override
	public Usuario buscar(String usuario) {
		// TODO Auto-generated method stub
		TypedQuery<Usuario> typedQuery = this.entityManager
				.createQuery("SELECT u FROM Usuario u WHERE u.usuarioNombre=:datoUsuario", Usuario.class);
		typedQuery.setParameter("datoUsuario", usuario);
		return typedQuery.getSingleResult();
	}
}
