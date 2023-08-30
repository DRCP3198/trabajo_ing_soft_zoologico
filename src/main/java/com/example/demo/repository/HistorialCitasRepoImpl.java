package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.HistorialCitas;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz de repositorio para la entidad HistorialCitas.
 */

@Transactional
@Repository
public class HistorialCitasRepoImpl implements IHistorialCitasRepo {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Inserta un nuevo registro de HistorialCitas en la base de datos.
     *
     * @param citas El objeto HistorialCitas a insertar.
     */
    @Override
    public void insertar(HistorialCitas citas) {
        this.entityManager.persist(citas);
    }

    /**
     * Busca registros de HistorialCitas por fecha de ingreso en la base de datos.
     *
     * @param fechaIngreso La fecha de ingreso para la búsqueda.
     * @return Una lista de HistorialCitas encontrados.
     */
    @Override
    public List<HistorialCitas> buscar(LocalDateTime fechaIngreso) {
        TypedQuery<HistorialCitas> typedQuery = this.entityManager.createQuery(
            "SELECT hc FROM HistorialCitas hc WHERE hc.fechaIngreso=:datoFechaIngreso", 
            HistorialCitas.class
        );
        typedQuery.setParameter("datoFechaIngreso", fechaIngreso);
        return typedQuery.getResultList();
    }

    /**
     * Elimina un registro de HistorialCitas por su ID de la base de datos.
     *
     * @param id El ID del registro a eliminar.
     */
    @Override
    public void eliminar(Integer id) {
        HistorialCitas citas = this.buscarId(id);
        this.entityManager.remove(citas);        
    }

    /**
     * Busca un registro de HistorialCitas por su ID en la base de datos.
     *
     * @param id El ID del registro a buscar.
     * @return El HistorialCitas encontrado.
     */
    @Override
    public HistorialCitas buscarId(Integer id) {
        return this.entityManager.find(HistorialCitas.class, id);
    }

    /**
     * Actualiza un registro de HistorialCitas en la base de datos.
     *
     * @param citas El objeto HistorialCitas con los detalles actualizados.
     */
    @Override
    public void actualizar(HistorialCitas citas) {
        this.entityManager.merge(citas);
    }

    /**
     * Obtiene todos los registros de HistorialCitas de la base de datos.
     *
     * @return Una lista de todos los registros de HistorialCitas.
     */
    @Override
    public List<HistorialCitas> buscarTodos() {
        TypedQuery<HistorialCitas> myQuery = this.entityManager.createQuery(
            "SELECT hc FROM HistorialCitas hc", 
            HistorialCitas.class
        );
        return myQuery.getResultList();
    }
}


