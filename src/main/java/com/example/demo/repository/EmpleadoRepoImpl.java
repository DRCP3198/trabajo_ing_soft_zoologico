package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class EmpleadoRepoImpl implements IEmpleadoRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.persist(empleado);
	}

	@Override
	public void actualizar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.entityManager.merge(empleado);
	}

	@Override
	public Empleado encontrar(String codigo) {
		// TODO Auto-generated method stub
		Query query = this.entityManager.createNativeQuery("select * from empleado where empl_codigo=:datoCodigo",
				Empleado.class);
		query.setParameter("datoCodigo", codigo);
		return (Empleado) query.getSingleResult();
	}

	@Override
	public void eliminar(String codigo) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.encontrar(codigo));
	}

	@Override
	public List<Empleado> encontrarTodos() {
		Query query = this.entityManager.createNativeQuery("select * from empleado ", Empleado.class);
		return query.getResultList();
	}

}
