package com.example.demo.service;

import com.example.demo.modelo.Habitat;

public interface IHabitatService {

	public void agregar(Habitat habitat);

	public void modificar(Habitat habitat);

	public Habitat encontrar(String tipo);

	public void borrar(String tipo);

}
