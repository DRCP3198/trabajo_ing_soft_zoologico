package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.CompraProveedores;


public interface ICompraProveedoresRepo {
	
	public void insertar(CompraProveedores compraProveedores);
	
	public List<CompraProveedores> buscarTodos();
	
	public void actualizar(CompraProveedores compraProveedores);
	

}
