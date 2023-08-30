package com.example.demo.repository;


import java.util.List;

import com.example.demo.modelo.HistorialClinico;

public interface IHistorialClinicoRepo {
	
	public void insertar(HistorialClinico historialClinico);
	
	public void actualizar(HistorialClinico historialClinico);
	
	public void eliminar(Integer id);
	
	public HistorialClinico seleccionar(Integer id);
	
	public List<HistorialClinico> buscarTodos();
}
