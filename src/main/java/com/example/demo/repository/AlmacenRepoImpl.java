package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Almacen;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz de repositorio para la entidad Almacen.
 */

@Repository
@Transactional
public class AlmacenRepoImpl implements IAlmacenRepo {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Inserta un nuevo registro de Almacen en la base de datos.
     *
     * @param almacen El Almacen a insertar.
     */
    @Override
    public void insertar(Almacen almacen) {
        this.entityManager.persist(almacen);
    }

    /**
     * Actualiza un registro de Almacen en la base de datos.
     *
     * @param almacen El Almacen con los detalles actualizados.
     */
    @Override
    public void actualizar(Almacen almacen) {
        this.entityManager.merge(almacen);
    }

    /**
     * Busca y devuelve un Almacen por su nombre.
     *
     * @param nombre El nombre del Almacen a buscar.
     * @return El Almacen encontrado, o null si no se encuentra.
     */
    @Override
    public Almacen buscar(String nombre) {
        TypedQuery<Almacen> typedQuery = this.entityManager
                .createQuery("SELECT al FROM Almacen al WHERE al.nombre=:datoNombre", Almacen.class);
        typedQuery.setParameter("datoNombre", nombre);

        List<Almacen> resultados = typedQuery.getResultList();
        if (!resultados.isEmpty()) {
            return resultados.get(0); // Retorna el primer resultado
        } else {
            return null; // Si no se encontró ningún resultado
        }
    }

    /**
     * Encuentra y devuelve una lista de todos los Almacenes.
     *
     * @return Una lista de todos los Almacenes.
     */
    @Override
    public List<Almacen> encontrarTodos() {
        TypedQuery<Almacen> typedQuery = this.entityManager.createQuery("SELECT a FROM Almacen a", Almacen.class);
        return typedQuery.getResultList();
    }

    /**
     * Elimina un registro de Almacen de la base de datos por su nombre.
     *
     * @param nombre El nombre del Almacen a eliminar.
     */
    @Override
    public void eliminar(String nombre) {
        Almacen almacen = this.buscar(nombre);
        if (almacen != null) {
            this.entityManager.remove(almacen);
        }
    }
}

