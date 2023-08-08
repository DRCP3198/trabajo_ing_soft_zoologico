package com.example.demo.repository;

import java.util.List;


import com.example.demo.modelo.Empleado;

public interface IEmpleadoRepo {
	
	public void insertar(Empleado empleado);

	public void actualizar(Empleado empleado);

	public Empleado encontrar(String codigo);

	public void eliminar(String codigo);

	public List<Empleado> encontrarTodos();

}
