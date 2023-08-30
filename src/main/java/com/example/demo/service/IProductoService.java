package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Producto;

public interface IProductoService {

	public void agregar(Producto producto);
	public void modificar(Producto producto);
	public Producto buscar(String codigo);
	public void borrar(String codigo);
	public List<Producto> reporte();

}
