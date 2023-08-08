package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;
import com.example.demo.repository.IProductoRepo;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo productoRepo;

	@Override
	public void agregar(Producto producto) {
		this.productoRepo.insertar(producto);
	}

	@Override
	public void modificar(Producto producto) {
		this.productoRepo.actualizar(producto);
	}

	@Override
	public Producto buscar(String codigo) {
		return this.productoRepo.encontrar(codigo);
	}

	@Override
	public void borrar(String codigo) {
		this.productoRepo.eliminar(codigo);
	}

	@Override
	public List<Producto> reporte() {
		return this.productoRepo.encontrarTodos();
	}

}
