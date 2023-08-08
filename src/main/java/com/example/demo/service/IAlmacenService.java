package com.example.demo.service;

import com.example.demo.modelo.Almacen;

public interface IAlmacenService {
	
	public void agregar(Almacen almacen);

	public void modificar(Almacen almacen);

	public Almacen encontrar(String nombre);

	public void borrar(String nombre);

}
