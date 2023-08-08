package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Animal;
import com.example.demo.repository.IAnimalRepo;

@Service
public class AnimalServiceImpl implements IAnimalService {

	@Autowired
	private IAnimalRepo animalRepo;
	
	@Override
	public void agregar(Animal animal) {
		this.animalRepo.insertar(animal);
		
	}

	@Override
	public void actualizar(Animal animal) {
		this.animalRepo.actualizar(animal);
		
	}

	@Override
	public void eliminar(String nombreComun) {
		this.animalRepo.eliminar(nombreComun);
		
	}

	@Override
	public Animal buscar(String nombreComun) {
		
		return this.animalRepo.seleccionar(nombreComun);
	}

	@Override
	public List<Animal> buscarTodos() {
		
		return this.animalRepo.encontrarTodos();
	}

}
