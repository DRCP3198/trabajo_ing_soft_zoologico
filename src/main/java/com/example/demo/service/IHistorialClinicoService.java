package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.HistorialClinico;

public interface IHistorialClinicoService {
	
	public void realizar(HistorialClinico historialClinico);
	
	public void actualizar(HistorialClinico historialClinico);
	
	public void eliminar(Integer id);
	
	public HistorialClinico buscar(Integer id);
	
	public List<HistorialClinico> buscarTodos();

}
