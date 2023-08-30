package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.ProveedorServicios;

public interface IProveedorServRepo {

	public void insertar(ProveedorServicios proveedorServicios);
	public void actualizar(ProveedorServicios proveedorServicios);
	public ProveedorServicios encontrar(String codigo);
	public void eliminar(String codigo);
	public List<ProveedorServicios> encontrarTodos();
}
