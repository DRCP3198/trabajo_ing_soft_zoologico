package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Almacen;

public interface IAlmacenService {

	public void agregar(Almacen almacen);

	public void modificar(Almacen almacen);

	public Almacen encontrar(String nombre);

	public void borrar(String nombre);

	public List<Almacen> encontrarTodos();

}