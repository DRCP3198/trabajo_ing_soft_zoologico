package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.HistorialCitas;

public interface IHistorialCitasService {
	
	public void agregar(HistorialCitas citas);
	public List<HistorialCitas> encontrar(String fechaIngreso);

}
