package com.example.demo.service;

import com.example.demo.modelo.HistorialClinico;

public interface IHistorialClinicoService {
	
	public void realizar(HistorialClinico historialClinico);
	
	public void actualizar(HistorialClinico historialClinico);
	
	public void eliminar(Integer id);
	
	public HistorialClinico buscar(Integer id);

}
