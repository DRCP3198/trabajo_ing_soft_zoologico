package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Empleado;
import com.example.demo.repository.IEmpleadoRepo;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepo empleadoRepo;
	@Autowired
	private IClienteService clienteService;

	@Override
	public void agregar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepo.insertar(empleado);
	}

	@Override
	public void modificar(Empleado empleado) {
		// TODO Auto-generated method stub
		this.empleadoRepo.actualizar(empleado);
	}

	@Override
	public Empleado buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.empleadoRepo.encontrar(codigo);
	}

	@Override
	public void borrar(String codigo) {
		// TODO Auto-generated method stub
		this.empleadoRepo.eliminar(codigo);
	}

	@Override
	public List<Empleado> reporte() {
		// TODO Auto-generated method stub
		return this.empleadoRepo.encontrarTodos();
	}

	@Override
	public Boolean autenticar(String usuario, String contraseni) {
		Empleado empleado = this.empleadoRepo.buscarUsuario(usuario);
		System.out.println("Usuario encontrado");
		if (empleado == null) {
			return false;
		} else {
			System.out.println(empleado.getContrasenia());
			System.out.println(contraseni);
			if (empleado.getContrasenia().equals(contraseni)) {
				System.out.println("Contraseña CORRECTA");
				return true;
			} else {
				System.out.println("CONTRASEÑA INCORRECTA");
				return false;
			}
		}
	}

	@Override
	public String siguienteVista(String usuario, String contrasenia) {
		if (this.autenticar(usuario, contrasenia)) {
			return "vInicioE";
		} else if (this.clienteService.autenticar(usuario, contrasenia)) {
			return "vistaCliente";
		} else {
			return "redirect:/inicio";
		}
	}
}
