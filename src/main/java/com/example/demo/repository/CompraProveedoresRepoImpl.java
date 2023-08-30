package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.CompraProveedores;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz de repositorio para la entidad CompraProvedores.
 */

@Repository
@Transactional
public class CompraProveedoresRepoImpl implements ICompraProveedoresRepo {
	
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Inserta un nuevo registro de CompraProveedores en la base de datos.
     *
     * @param compraProveedores La compra de proveedores a insertar.
     */
    @Override
    public void insertar(CompraProveedores compraProveedores) {
        this.entityManager.persist(compraProveedores);
    }

    /**
     * Obtiene todos los registros de CompraProveedores de la base de datos.
     *
     * @return Una lista de todas las compras de proveedores.
     */
    @Override
    public List<CompraProveedores> buscarTodos() {
        TypedQuery<CompraProveedores> query = this.entityManager.createQuery("SELECT c FROM CompraProveedores c", CompraProveedores.class);
        return query.getResultList();
    }

    /**
     * Actualiza un registro de CompraProveedores en la base de datos.
     *
     * @param compraProveedores La compra de proveedores con los detalles actualizados.
     */
    @Override
    public void actualizar(CompraProveedores compraProveedores) {
        this.entityManager.merge(compraProveedores);
    }
}

