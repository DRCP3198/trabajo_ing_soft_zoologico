package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Empleado;

public interface IEmpleadoService {
	
	public void agregar(Empleado empleado);

	public void modificar(Empleado empleado);

	public Empleado buscar(String codigo);

	public void borrar(String codigo);
	// VERIFICAR USUARIO
		public Boolean autenticar(String usuario, String contraseni);
		
	//pasar siguiente vista 
	public String siguienteVista(String usuario, String contrasenia);

	public List<Empleado> reporte();

}
