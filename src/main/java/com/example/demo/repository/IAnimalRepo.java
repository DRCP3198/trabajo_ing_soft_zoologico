package com.example.demo.repository;

import java.util.List;



import com.example.demo.modelo.Animal;




public interface IAnimalRepo {
	
	public void insertar(Animal animal);
	
	public void actualizar(Animal animal);
	
	public void eliminar(String nombreComun);
	
	public Animal seleccionar(String nombreComun);
	
	public List<Animal>encontrarTodos();

}
