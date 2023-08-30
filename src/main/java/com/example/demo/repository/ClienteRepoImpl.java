package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz de repositorio para la entidad Cliente.
 */

@Transactional
@Repository
public class ClienteRepoImpl implements IClienteRepo {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Inserta un nuevo registro de Cliente en la base de datos.
     *
     * @param cliente El cliente a insertar.
     */
    @Override
    public void insertar(Cliente cliente) {
        this.entityManager.persist(cliente);
    }

    /**
     * Actualiza un registro de Cliente en la base de datos.
     *
     * @param id El ID del cliente a actualizar.
     */
    @Override
    public void actualizar(Integer id) {
        this.entityManager.merge(id);
    }

    /**
     * Busca un Cliente por su nombre de usuario en la base de datos.
     *
     * @param usuario El nombre de usuario a buscar.
     * @return El cliente correspondiente al nombre de usuario o null si no se encuentra.
     */
    @Override
    public Cliente encontrarUsuario(String usuario) {
        TypedQuery<Cliente> typedQuery = this.entityManager.createQuery(
            "SELECT cli FROM Cliente cli WHERE cli.usuarioGeneral = :datoUsuario", 
            Cliente.class
        );
        typedQuery.setParameter("datoUsuario", usuario);
        try {
            return typedQuery.getSingleResult();
        } catch (Exception e) {
            System.err.println("Usuario no encontrado");
            return null;
        }
    }

    /**
     * Busca un Cliente por su número de cédula en la base de datos.
     *
     * @param cedula El número de cédula a buscar.
     * @return El cliente correspondiente al número de cédula o null si no se encuentra.
     */
    @Override
    public Cliente encontrarCedula(String cedula) {
        TypedQuery<Cliente> query = this.entityManager.createQuery(
            "SELECT c FROM Cliente c WHERE c.cedula = :datoCedula", 
            Cliente.class
        );
        query.setParameter("datoCedula", cedula);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return query.getResultList().get(0);
        }
    }

    /**
     * Obtiene todos los registros de Cliente de la base de datos.
     *
     * @return Una lista de todos los clientes.
     */
    @Override
    public List<Cliente> encontrarTodos() {
        TypedQuery<Cliente> query = this.entityManager.createQuery("SELECT cli FROM Cliente cli", Cliente.class);
        return query.getResultList();
    }

    /**
     * Actualiza un registro de Cliente en la base de datos.
     *
     * @param cliente El cliente con los detalles actualizados.
     */
    @Override
    public void actualizarCliente(Cliente cliente) {
        this.entityManager.merge(cliente);
    }

    /**
     * Busca un Cliente por su ID en la base de datos.
     *
     * @param id El ID del cliente a buscar.
     * @return El cliente correspondiente al ID o null si no se encuentra.
     */
    @Override
    public Cliente encontrarId(Integer id) {
        return this.entityManager.find(Cliente.class, id);
    }

    /**
     * Elimina un Cliente por su ID de la base de datos.
     *
     * @param id El ID del cliente a eliminar.
     */
    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.encontrarId(id));
    }

}

