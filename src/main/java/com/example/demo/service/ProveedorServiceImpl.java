package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Proveedor;
import com.example.demo.repository.IProveedorRepo;

@Service
public class ProveedorServiceImpl implements IProveedorService {

	@Autowired
	private IProveedorRepo proveedorRepo;

	@Override
	public void agregar(Proveedor proveedor) {
		this.proveedorRepo.insertar(proveedor);
	}

	@Override
	public void modificar(Proveedor proveedor) {
		this.proveedorRepo.actualizar(proveedor);
	}

	@Override
	public Proveedor buscar(String codigo) {
		return this.proveedorRepo.encontrar(codigo);
	}

	@Override
	public void borrar(String codigo) {
		this.proveedorRepo.eliminar(codigo);
	}

	@Override
	public List<Proveedor> reporte() {
		return this.proveedorRepo.encontrarTodos();
	}

}
