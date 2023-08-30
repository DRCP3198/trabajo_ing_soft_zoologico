package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.AdquirirServicioProveedor;

public interface IAdquirirServicioService {

public void insertar(AdquirirServicioProveedor adquirirServicioProveedor);
	
	public List<AdquirirServicioProveedor> buscarTodos();
	
	public void actualizar(AdquirirServicioProveedor adquirirServicioProveedor);
}
