package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.citaHistorialClinico;

public interface IcitaHistorialClinicoRepository {

	public void insertar(citaHistorialClinico citaHistorialClinico);
	public void actualizar(citaHistorialClinico citaHistorialClinico);
	public List<citaHistorialClinico> buscarTodos();
}
