package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.modelo.HistorialCitas;

public interface IHistorialCitasService {
	
	public void agregar(HistorialCitas citas);
	public List<HistorialCitas> encontrar(LocalDateTime fechaIngreso);
	public HistorialCitas buscarId(Integer id);
	public void eliminar(Integer id);
	public void actualizar(HistorialCitas citas);
	
	public List<HistorialCitas> buscarTodos();
}
