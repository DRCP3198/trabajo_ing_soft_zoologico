package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.ProveedorServicios;
import com.example.demo.repository.IProveedorServRepo;

@Service
public class ProveedorServiciosServiceImpl implements IProveedorServiciosService{

	@Autowired
	private IProveedorServRepo iProveedorServRepo;
	
	@Override
	public void agregar(ProveedorServicios proveedorServicios) {
		this.iProveedorServRepo.insertar(proveedorServicios);
	}

	@Override
	public void modificar(ProveedorServicios proveedorServicios) {
		this.iProveedorServRepo.actualizar(proveedorServicios);
	}

	@Override
	public ProveedorServicios buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.iProveedorServRepo.encontrar(codigo);
	}

	@Override
	public void borrar(String codigo) {
		this.iProveedorServRepo.eliminar(codigo);
		
	}

	@Override
	public List<ProveedorServicios> reporte() {
		// TODO Auto-generated method stub
		return this.iProveedorServRepo.encontrarTodos();
	}

}
