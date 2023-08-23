package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Almacen;

public interface IAlmacenRepo {

	public void insertar(Almacen almacen);

	public void actualizar(Almacen almacen);

	public Almacen buscar(String nombre);

	public void eliminar(String nombre);

	public List<Almacen> encontrarTodos();

}
