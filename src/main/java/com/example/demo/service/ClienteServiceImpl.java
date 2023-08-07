package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.repository.IClienteRepo;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteRepo clienteRepo;
	
	

	@Override
	public void agregar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.insertar(cliente);
	}

	@Override
	public void modificar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.actualizar(cliente);
	}

	@Override
	public Cliente buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepo.encontrar(cedula);
	}

	@Override
	public void borrar(String cedula) {
		// TODO Auto-generated method stub
		this.clienteRepo.eliminar(cedula);
	}

	@Override
	public List<Cliente> reporte() {
		// TODO Auto-generated method stub
		return this.clienteRepo.encontrarTodos();
	}

	@Override
	public Boolean autenticar(String usuario, String contrasenia) {
		Cliente cliente = this.clienteRepo.encontrar(usuario);
		System.out.println("Encontro el usuario");
		if (cliente == null) {
			return false;
		} else {
			System.out.println(cliente.getContrasenia());
			System.out.println(contrasenia);
			if (cliente.getContrasenia().equals(contrasenia)) {
				System.out.println("Contraseña Correcta");
				return true;
			} else {
				System.out.println("Contraseña Incorrecta");
				return false;
			}
		}
	}
	

}
