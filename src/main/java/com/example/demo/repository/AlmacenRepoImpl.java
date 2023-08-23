package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Almacen;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AlmacenRepoImpl implements IAlmacenRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Almacen almacen) {
		// TODO Auto-generated method stub
		this.entityManager.persist(almacen);
	}

	@Override
	public void actualizar(Almacen almacen) {
		// TODO Auto-generated method stub
		this.entityManager.merge(almacen);
	}

	@Override
	public Almacen buscar(String nombre) {
	    TypedQuery<Almacen> typedQuery = this.entityManager
	            .createQuery("SELECT al FROM Almacen al WHERE al.nombre=:datoNombre", Almacen.class);
	    typedQuery.setParameter("datoNombre", nombre);
	    
	    List<Almacen> resultados = typedQuery.getResultList();
	    if (!resultados.isEmpty()) {
	        return resultados.get(0); 
	    } else {
	        return null;  
	    }
	}


	public List<Almacen> encontrarTodos() {
	    TypedQuery<Almacen> typedQuery = this.entityManager.createQuery("SELECT a FROM Almacen a", Almacen.class);
	    return typedQuery.getResultList();
	}

	@Override
	public void eliminar(String nombre) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscar(nombre));

	}

}
