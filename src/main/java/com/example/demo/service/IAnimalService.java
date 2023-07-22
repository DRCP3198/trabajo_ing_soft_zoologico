package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Animal;

public interface IAnimalService {
	public void agregar(Animal animal);
	
	public void actualizar(Animal animal);
	
	public void eliminar(String nombreComun);
	
	public Animal buscar(String nombreComun);
	
	public List<Animal>buscarTodos();

}
