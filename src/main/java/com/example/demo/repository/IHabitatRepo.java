package com.example.demo.repository;

import com.example.demo.modelo.Habitat;

public interface IHabitatRepo {

	public void insertar(Habitat habitat);

	public void actualizar(Habitat habitat);

	public Habitat buscar(String tipo);

	public void eliminar(String tipo);

}
