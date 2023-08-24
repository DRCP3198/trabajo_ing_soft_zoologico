package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.citaHistorialClinico;

public interface IcitaHistorialClinicoService {

	public void insertar(citaHistorialClinico citaHistorialClinico);
	public void actualizar(citaHistorialClinico citaHistorialClinico);
	public List<citaHistorialClinico> buscarTodos();
}
