package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Proveedor;

public interface IProveedorService {

	public void agregar(Proveedor proveedor);
	public void modificar(Proveedor proveedor);
	public Proveedor buscar(String codigo);
	public void borrar(String codigo);
	public List<Proveedor> reporte();

}
