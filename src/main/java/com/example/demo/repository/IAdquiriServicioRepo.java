package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.AdquirirServicioProveedor;
import com.example.demo.modelo.ProveedorServicios;

public interface IAdquiriServicioRepo {

	public void insertar(AdquirirServicioProveedor adquirirServicioProveedor);
	
	public List<AdquirirServicioProveedor> buscarTodos();
	
	public void actualizar(AdquirirServicioProveedor adquirirServicioProveedor);
}
