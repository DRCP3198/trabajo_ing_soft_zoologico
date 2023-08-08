package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Proveedor;

public interface IProveedorRepo {
      
	public void insertar(Proveedor proveedor);
	public void actualizar(Proveedor proveedor);
	public Proveedor encontrar(String codigo);
	public void eliminar(String codigo);
	public List<Proveedor> encontrarTodos();
	
}
