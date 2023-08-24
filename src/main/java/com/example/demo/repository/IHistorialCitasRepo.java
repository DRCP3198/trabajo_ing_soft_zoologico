package com.example.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.modelo.HistorialCitas;

public interface IHistorialCitasRepo {
	
	public void insertar(HistorialCitas citas);
	public List<HistorialCitas> buscar(LocalDateTime fechaIngreso);
	public HistorialCitas buscarId(Integer id);
	public void eliminar(Integer id);
	public void actualizar(HistorialCitas citas);
	
	public List<HistorialCitas> buscarTodos();
	
}
