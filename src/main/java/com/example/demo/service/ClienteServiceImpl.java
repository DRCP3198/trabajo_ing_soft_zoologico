package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.repository.IClienteRepo;
import com.example.demo.repository.IEmpleadoRepo;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	@Autowired
	private IClienteRepo clienteRepo;
	
	@Autowired 
	private IEmpleadoRepo empleadoRepo;

	@Override
	public void agregar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.insertar(cliente);
	}

	@Override
	public void modificar(Integer id) {
		// TODO Auto-generated method stub
		this.clienteRepo.actualizar(id);
	}

	@Override
	public Cliente buscar(String cedula) {
		// TODO Auto-generated method stub
		return this.clienteRepo.encontrarCedula(cedula);
	}


	@Override
	public List<Cliente> reporte() {
		// TODO Auto-generated method stub
		return this.clienteRepo.encontrarTodos();
	}

	@Override
	public Boolean autenticar(String user, String pass) {
		Cliente cliente = this.clienteRepo.encontrarUsuario(user);
		System.out.println("Encontro el usuario");
		if (cliente == null) {
			return false;
		} else {
			System.out.println(cliente.getContrasenia());
			System.out.println(pass);
			if (cliente.getContrasenia().equals(pass)) {
				System.out.println("Contraseña Correcta");
				return true;
			} else {
				System.out.println("Contraseña incorrecta");
				return false;
			}
		}
	}

	
	public String siguienteVistaCliente(String user, String pass) {
		if (this.autenticar(user, pass)) {
			return "vistaCliente";
		} else {
			return "redirect:/inicio";
		}
	}

	@Override
	public void modificarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		this.clienteRepo.actualizarCliente(cliente);
		
	}

	@Override
	public Cliente buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.clienteRepo.encontrarId(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.clienteRepo.eliminar(id);
	}
	
	

}
