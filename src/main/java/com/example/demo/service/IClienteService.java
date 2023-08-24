package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Cliente;

public interface IClienteService {
	
	public void agregar(Cliente cliente);
	public void modificar(Integer id);
	public void modificarCliente(Cliente cliente);
	public Cliente buscar(String cedula);
	public void eliminar(Integer id);
	public Cliente buscarId(Integer id); 

	// VERIFICAR USUARIO
	public Boolean autenticar(String user, String pass);
	
	//pasar siguiente vista 
	public String siguienteVistaCliente(String user, String pass);
	public List<Cliente> reporte();

}
