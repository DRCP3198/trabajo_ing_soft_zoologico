package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Cliente;

public interface IClienteService {
	
	public void agregar(Cliente cliente);
	public void modificar(Cliente cliente);
	public Cliente buscar(String cedula);
	public void borrar(String cedula);
	public List<Cliente> reporte();

}
