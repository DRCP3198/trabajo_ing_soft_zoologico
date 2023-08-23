package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Producto;

public interface IProductoRepo {
      
	public void insertar(Producto producto);
	public void actualizar(Producto producto);
	public Producto encontrar(String codigo);
	public void eliminar(String codigo);
	public List<Producto> encontrarTodos();
	
}
