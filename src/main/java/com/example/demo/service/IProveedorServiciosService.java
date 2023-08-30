package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.ProveedorServicios;

public interface IProveedorServiciosService {

	public void agregar(ProveedorServicios proveedorServicios);
	public void modificar(ProveedorServicios proveedorServicios);
	public ProveedorServicios buscar(String codigo);
	public void borrar(String codigo);
	public List<ProveedorServicios> reporte();
}
