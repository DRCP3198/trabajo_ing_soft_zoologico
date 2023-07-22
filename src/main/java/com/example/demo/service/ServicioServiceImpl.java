package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Servicio;
import com.example.demo.repository.IServicioRepo;

@Service
public class ServicioServiceImpl implements IServicioService {

	@Autowired
	private IServicioRepo servicioRepo;

	@Override
	public void agregar(Servicio servicio) {
		this.servicioRepo.insertar(servicio);
	}

	@Override
	public void modificar(Servicio servicio) {
		this.servicioRepo.actualizar(servicio);
	}

	@Override
	public Servicio buscar(String codigo) {
		return this.servicioRepo.encontrar(codigo);
	}

	@Override
	public void borrar(String codigo) {
		this.servicioRepo.eliminar(codigo);
	}

	@Override
	public List<Servicio> reporte() {
		return this.servicioRepo.encontrarTodos();
	}

}
