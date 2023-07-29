package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.HistorialClinico;
import com.example.demo.repository.IHistorialClinicoRepo;

@Service
public class HistorialClinicoService implements IHistorialClinicoService {

	@Autowired
	private IHistorialClinicoRepo clinicoRepo;
	
	@Override
	public void realizar(HistorialClinico historialClinico) {
		this.clinicoRepo.insertar(historialClinico);
		
	}

	@Override
	public void actualizar(HistorialClinico historialClinico) {
		this.clinicoRepo.actualizar(historialClinico);
		
	}

	@Override
	public void eliminar(Integer id) {
		this.clinicoRepo.eliminar(id);
		
	}

	@Override
	public HistorialClinico buscar(Integer id) {
		
		return this.clinicoRepo.seleccionar(id);
	}
	

}
