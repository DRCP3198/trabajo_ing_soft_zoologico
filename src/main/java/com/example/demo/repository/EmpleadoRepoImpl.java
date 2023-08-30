package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz de repositorio para la entidad Empleados.
 */

@Transactional
@Repository
public class EmpleadoRepoImpl implements IEmpleadoRepo {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Inserta un nuevo registro de Empleado en la base de datos.
     *
     * @param empleado El empleado a insertar.
     */
    @Override
    public void insertar(Empleado empleado) {
        this.entityManager.persist(empleado);
    }

    /**
     * Actualiza un registro de Empleado en la base de datos.
     *
     * @param empleado El empleado con los detalles actualizados.
     */
    @Override
    public void actualizar(Empleado empleado) {
        this.entityManager.merge(empleado);
    }

    /**
     * Encuentra un registro de Empleado por su código en la base de datos.
     *
     * @param codigo El código del empleado a buscar.
     * @return El empleado encontrado.
     */
    @Override
    public Empleado encontrar(String codigo) {
        Query query = this.entityManager.createNativeQuery("select * from empleado where empl_codigo=:datoCodigo", Empleado.class);
        query.setParameter("datoCodigo", codigo);
        return (Empleado) query.getSingleResult();
    }

    /**
     * Elimina un registro de Empleado por su código de la base de datos.
     *
     * @param codigo El código del empleado a eliminar.
     */
    @Override
    public void eliminar(String codigo) {
        this.entityManager.remove(this.encontrar(codigo));
    }

    /**
     * Obtiene todos los registros de Empleado de la base de datos.
     *
     * @return Una lista de todos los empleados.
     */
    @Override
    public List<Empleado> encontrarTodos() {
        Query query = this.entityManager.createNativeQuery("select * from empleado", Empleado.class);
        return query.getResultList();
    }

    /**
     * Busca un registro de Empleado por su ID en la base de datos.
     *
     * @param id El ID del empleado a buscar.
     * @return El empleado encontrado.
     */
    @Override
    public Empleado buscar(Integer id) {
        return this.entityManager.find(Empleado.class, id);
    }

    /**
     * Busca un registro de Empleado por su usuario en la base de datos.
     *
     * @param usuario El nombre de usuario del empleado a buscar.
     * @return El empleado encontrado.
     */
    @Override
    public Empleado buscarUsuario(String usuario) {
        TypedQuery<Empleado> query = this.entityManager.createQuery("SELECT e FROM Empleado e WHERE e.usuarioGeneral = :datoUsuario", Empleado.class);
        query.setParameter("datoUsuario", usuario);
        
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            System.err.println("Usuario no encontrado");
            return null;
        }
    }
}

