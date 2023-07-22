package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Animal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class AnimalRepoImpl implements IAnimalRepo{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Animal animal) {
		this.entityManager.persist(animal);
		
	}

	@Override
	public void actualizar(Animal animal) {
		this.entityManager.merge(animal);
		
	}

	@Override
	public void eliminar(String nombreComun) {
	
		this.entityManager.remove(this.seleccionar(nombreComun));
		
		
	}

	@Override
	public Animal seleccionar(String nombreComun) {
		TypedQuery<Animal> myQuery = this.entityManager.createQuery("Select anim from anim WHERE anim.nombreComun=:datoNombre",Animal.class);
		myQuery.setParameter("datoNombre", nombreComun);
		return myQuery.getSingleResult();
	}

	@Override
	public List<Animal> encontrarTodos() {
		TypedQuery<Animal> myQuery= this.entityManager.createQuery("Select anim from Animal anim",Animal.class);
		return myQuery.getResultList();
	}

}
