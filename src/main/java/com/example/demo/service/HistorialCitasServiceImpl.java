package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.HistorialCitas;
import com.example.demo.repository.IHistorialCitasRepo;

@Service
public class HistorialCitasServiceImpl implements IHistorialCitasService{
	
	@Autowired
	private IHistorialCitasRepo citasRepo;

	@Override
	public void agregar(HistorialCitas citas) {
		// TODO Auto-generated method stub
		this.citasRepo.insertar(citas);
	}

	@Override
	public List<HistorialCitas> encontrar(String fechaIngreso) {
		// TODO Auto-generated method stub
		return this.citasRepo.buscar(fechaIngreso);
	}

}
