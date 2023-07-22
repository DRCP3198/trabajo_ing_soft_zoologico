package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Servicio;

public interface IServicioRepo {
      
	public void insertar(Servicio servicio);
	public void actualizar(Servicio servicio);
	public Servicio encontrar(String codigo);
	public void eliminar(String codigo);
	public List<Servicio> encontrarTodos();
	
}
