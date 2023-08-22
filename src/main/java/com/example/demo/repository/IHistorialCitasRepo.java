package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.HistorialCitas;

public interface IHistorialCitasRepo {
	
	public void insertar(HistorialCitas citas);
	public List<HistorialCitas> buscar(String fechaIngreso);

}
