package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Habitat;

public interface IHabitatService {

	public void agregar(Habitat habitat);

	public void modificar(Habitat habitat);

	public Habitat encontrar(String tipo);

	public void borrar(String tipo);
	
	public List<Habitat>encontrarTodos();
	
	public Habitat buscarPorId(Integer id);
	
	public void eliminarPorId(Integer id);

}
