package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Servicio;

public interface IServicioService {

	public void agregar(Servicio servicio);
	public void modificar(Servicio servicio);
	public Servicio buscar(String codigo);
	public void borrar(String codigo);
	public List<Servicio> reporte();

}
