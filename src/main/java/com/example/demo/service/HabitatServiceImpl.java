package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Habitat;
import com.example.demo.repository.IHabitatRepo;

@Service
public class HabitatServiceImpl implements IHabitatService {

	@Autowired
	private IHabitatRepo habitatRepo;

	@Override
	public void agregar(Habitat habitat) {
		// TODO Auto-generated method stub
		this.habitatRepo.insertar(habitat);
	}

	@Override
	public void modificar(Habitat habitat) {
		// TODO Auto-generated method stub
		this.habitatRepo.actualizar(habitat);
	}

	@Override
	public Habitat encontrar(String tipo) {
		// TODO Auto-generated method stub
		return this.habitatRepo.buscar(tipo);
	}

	@Override
	public void borrar(String tipo) {
		// TODO Auto-generated method stub
		this.habitatRepo.eliminar(tipo);
	}

}
