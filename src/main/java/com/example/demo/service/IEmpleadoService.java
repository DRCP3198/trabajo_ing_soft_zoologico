package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Empleado;

public interface IEmpleadoService {
	
	public void agregar(Empleado empleado);

	public void modificar(Empleado empleado);

	public Empleado buscar(String codigo);

	public void borrar(String codigo);

	public List<Empleado> reporte();

}
