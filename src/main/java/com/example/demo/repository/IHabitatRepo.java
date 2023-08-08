package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Animal;
import com.example.demo.modelo.Habitat;

public interface IHabitatRepo {

	public void insertar(Habitat habitat);

	public void actualizar(Habitat habitat);

	public Habitat buscar(String tipo);

	public void eliminar(String tipo);
	
	public List<Habitat>encontrarTodos();
	
	public Habitat buscarPorId(Integer id);
	
	public void eliminarPorId(Integer id);

}
