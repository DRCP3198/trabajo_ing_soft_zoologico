package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.citaHistorialClinico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz de repositorio para la entidad HistorialClinico.
 */

@Repository
@Transactional
public class citaHistorialClinicoRepoImpl implements IcitaHistorialClinicoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Inserta un nuevo registro de citaHistorialClinico en la base de datos.
     *
     * @param citaHistorialClinico La cita de historial clínico a insertar.
     */
    @Override
    public void insertar(citaHistorialClinico citaHistorialClinico) {
        this.entityManager.persist(citaHistorialClinico);
    }

    /**
     * Actualiza un registro de citaHistorialClinico en la base de datos.
     *
     * @param citaHistorialClinico La cita de historial clínico con los detalles actualizados.
     */
    @Override
    public void actualizar(citaHistorialClinico citaHistorialClinico) {
        this.entityManager.merge(citaHistorialClinico);
    }

    /**
     * Obtiene todos los registros de citaHistorialClinico de la base de datos.
     *
     * @return Una lista de todas las citas de historial clínico.
     */
    @Override
    public List<citaHistorialClinico> buscarTodos() {
        TypedQuery<citaHistorialClinico> myQuery = this.entityManager.createQuery(
            "SELECT hc FROM citaHistorialClinico hc", 
            citaHistorialClinico.class
        );
        return myQuery.getResultList();
    }
}
