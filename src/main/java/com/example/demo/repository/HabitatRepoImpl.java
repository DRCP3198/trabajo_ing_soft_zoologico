package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Habitat;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz de repositorio para la entidad Habitat.
 */

@Transactional
@Repository
public class HabitatRepoImpl implements IHabitatRepo {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Inserta un nuevo registro de Habitat en la base de datos.
     *
     * @param habitat El hábitat a insertar.
     */
    @Override
    public void insertar(Habitat habitat) {
        this.entityManager.persist(habitat);
    }

    /**
     * Actualiza un registro de Habitat en la base de datos.
     *
     * @param habitat El hábitat con los detalles actualizados.
     */
    @Override
    public void actualizar(Habitat habitat) {
        this.entityManager.merge(habitat);
    }

    /**
     * Busca un registro de Habitat por su tipo en la base de datos.
     *
     * @param tipo El tipo de hábitat a buscar.
     * @return El hábitat encontrado.
     */
    @Override
    public Habitat buscar(String tipo) {
        TypedQuery<Habitat> typedQuery = this.entityManager.createQuery("SELECT h FROM Habitat h WHERE h.tipo=:datoTipo", Habitat.class);
        typedQuery.setParameter("datoTipo", tipo);
        return typedQuery.getSingleResult();
    }

    /**
     * Elimina un registro de Habitat por su tipo de la base de datos.
     *
     * @param tipo El tipo de hábitat a eliminar.
     */
    @Override
    public void eliminar(String tipo) {
        this.entityManager.remove(this.buscar(tipo));
    }

    /**
     * Obtiene todos los registros de Habitat de la base de datos.
     *
     * @return Una lista de todos los hábitats.
     */
    @Override
    public List<Habitat> encontrarTodos() {
        TypedQuery<Habitat> myQuery = this.entityManager.createQuery("SELECT h FROM Habitat h", Habitat.class);
        return myQuery.getResultList();
    }

    /**
     * Busca un registro de Habitat por su ID en la base de datos.
     *
     * @param id El ID del hábitat a buscar.
     * @return El hábitat encontrado.
     */
    @Override
    public Habitat buscarPorId(Integer id) {
        return this.entityManager.find(Habitat.class, id);
    }

    /**
     * Elimina un registro de Habitat por su ID de la base de datos.
     *
     * @param id El ID del hábitat a eliminar.
     */
    @Override
    public void eliminarPorId(Integer id) {
        Habitat h = this.buscarPorId(id);
        this.entityManager.remove(h);
    }
}

