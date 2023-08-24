package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.CompraProveedores;


public interface ICompraProveedoresService {
	
	public void insertar(CompraProveedores compraProveedores);
	
	public List<CompraProveedores> buscarTodos();
	
	public void actualizar(CompraProveedores compraProveedores);

}
