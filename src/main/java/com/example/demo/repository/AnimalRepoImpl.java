package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Animal;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz de repositorio para la entidad Animal.
 */

@Transactional
@Repository
public class AnimalRepoImpl implements IAnimalRepo {
    
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Inserta un nuevo registro de Animal en la base de datos.
     *
     * @param animal El Animal a insertar.
     */
    @Override
    public void insertar(Animal animal) {
        this.entityManager.persist(animal);
    }

    /**
     * Actualiza un registro de Animal en la base de datos.
     *
     * @param animal El Animal con los detalles actualizados.
     */
    @Override
    public void actualizar(Animal animal) {
        this.entityManager.merge(animal);
    }

    /**
     * Elimina un registro de Animal de la base de datos por su nombre común.
     *
     * @param nombreComun El nombre común del Animal a eliminar.
     */
    @Override
    public void eliminar(String nombreComun) {
        Animal animal = this.seleccionar(nombreComun);
        if (animal != null) {
            this.entityManager.remove(animal);
        }
    }

    /**
     * Busca y selecciona un registro de Animal en la base de datos por su nombre común.
     *
     * @param nombreComun El nombre común del Animal a buscar y seleccionar.
     * @return El Animal encontrado, o null si no se encuentra.
     */
    @Override
    public Animal seleccionar(String nombreComun) {
        TypedQuery<Animal> myQuery = this.entityManager.createQuery(
            "SELECT anim FROM Animal anim WHERE anim.nombreComun=:datoNombre", 
            Animal.class
        );
        myQuery.setParameter("datoNombre", nombreComun);
        return myQuery.getSingleResult();
    }

    /**
     * Obtiene todos los registros de Animales de la base de datos.
     *
     * @return Una lista de todos los Animales.
     */
    @Override
    public List<Animal> encontrarTodos() {
        TypedQuery<Animal> myQuery = this.entityManager.createQuery("SELECT anim FROM Animal anim", Animal.class);
        return myQuery.getResultList();
    }

    /**
     * Busca un registro de Animal en la base de datos por su ID.
     *
     * @param id El ID del Animal a buscar.
     * @return El Animal encontrado, o null si no se encuentra.
     */
    @Override
    public Animal buscarPorId(Integer id) {
        return this.entityManager.find(Animal.class, id);
    }

    /**
     * Elimina un registro de Animal de la base de datos por su ID.
     *
     * @param id El ID del Animal a eliminar.
     */
    @Override
    public void eliminarPorID(Integer id) {
        Animal animal = this.buscarPorId(id);
        if (animal != null) {
            this.entityManager.remove(animal);
        }
    }
}

