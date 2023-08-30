package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Proveedor;
import com.example.demo.modelo.ProveedorServicios;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ProveedorServiciosImpl implements IProveedorServRepo{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(ProveedorServicios proveedorServicios) {
		this.entityManager.persist(proveedorServicios);
	}

	@Override
	public void actualizar(ProveedorServicios proveedorServicios) {
		this.entityManager.merge(proveedorServicios);
	}

	@Override
	public ProveedorServicios encontrar(String codigo) {
		TypedQuery<ProveedorServicios> typedQuery = this.entityManager
				.createQuery("SELECT prov FROM ProveedorServicios prov WHERE prov.codigo=:datoCodigo", ProveedorServicios.class);
		typedQuery.setParameter("datoCodigo", codigo);
		return typedQuery.getSingleResult();
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.encontrar(codigo));
	}

	@Override
	public List<ProveedorServicios> encontrarTodos() {
		TypedQuery<ProveedorServicios> query = this.entityManager.createQuery("SELECT prov FROM ProveedorServicios prov", ProveedorServicios.class);
		return query.getResultList();
	}

	
}
