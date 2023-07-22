package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Empleado;
import com.example.demo.repository.IEmpleadoRepo;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepo empleadoRepo;

	@Override
	public void agregar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepo.insertar(empleado);
	}

	@Override
	public void modificar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepo.actualizar(empleado);
	}

	@Override
	public Empleado buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.empleadoRepo.encontrar(codigo);
	}

	@Override
	public void borrar(String codigo) {
		// TODO Auto-generated method stub
		this.empleadoRepo.eliminar(codigo);
	}

	@Override
	public List<Empleado> reporte() {
		// TODO Auto-generated method stub
		return this.empleadoRepo.encontrarTodos();
	}

}
