package com.example.demo.repository;

import java.util.List;

import com.example.demo.modelo.Cliente;

public interface IClienteRepo {
      
	public void insertar(Cliente cliente);
	public void actualizar(Cliente cliente);
	public Cliente encontrarCedula(String cedula);
	public Cliente encontrarUsuario(String usuario);
	public void eliminar(String cedula);
	public List<Cliente> encontrarTodos();
	

}
