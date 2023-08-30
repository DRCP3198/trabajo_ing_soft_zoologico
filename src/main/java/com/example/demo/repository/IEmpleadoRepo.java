package com.example.demo.repository;

import java.util.List;


import com.example.demo.modelo.Empleado;

public interface IEmpleadoRepo {
	
	public void insertar(Empleado empleado);
	
	public Empleado buscar(Integer id);

	public void actualizar(Empleado empleado);

	public Empleado encontrar(String codigo);
	public Empleado buscarUsuario(String usuario);

	public void eliminar(String codigo);

	public List<Empleado> encontrarTodos();

}
