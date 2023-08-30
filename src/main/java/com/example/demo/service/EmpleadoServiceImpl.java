package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Empleado;
import com.example.demo.repository.IEmpleadoRepo;

/**
 * Implementación del servicio para gestionar empleados.
 */
@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepo empleadoRepo;

	@Autowired
	private IClienteService clienteService;

	/**
	 * Agrega un nuevo empleado a la base de datos.
	 *
	 * @param empleado El empleado que se va a agregar.
	 */
	@Override
	public void agregar(Empleado empleado) {
		this.empleadoRepo.insertar(empleado);
	}

	/**
	 * Modifica los datos de un empleado existente en la base de datos.
	 *
	 * @param empleado El empleado con los datos actualizados.
	 */
	@Override
	public void modificar(Empleado empleado) {
		this.empleadoRepo.actualizar(empleado);
	}

	/**
	 * Busca un empleado por su código en la base de datos.
	 *
	 * @param codigo El código del empleado a buscar.
	 * @return El empleado encontrado, o null si no se encontró.
	 */
	@Override
	public Empleado buscar(String codigo) {
		return this.empleadoRepo.encontrar(codigo);
	}

	/**
	 * Elimina un empleado por su código en la base de datos.
	 *
	 * @param codigo El código del empleado a eliminar.
	 */
	@Override
	public void borrar(String codigo) {
		this.empleadoRepo.eliminar(codigo);
	}

	/**
	 * Genera un informe de todos los empleados almacenados en la base de datos.
	 *
	 * @return Una lista de empleados.
	 */
	@Override
	public List<Empleado> reporte() {
		return this.empleadoRepo.encontrarTodos();
	}

	/**
	 * Autentica a un empleado utilizando su usuario y contraseña.
	 *
	 * @param usuario    El nombre de usuario del empleado.
	 * @param contraseni La contraseña del empleado.
	 * @return true si la autenticación es exitosa, false de lo contrario.
	 */
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

	/**
	 * Determina la siguiente vista en función de la autenticación del usuario.
	 *
	 * @param usuario    El nombre de usuario.
	 * @param contrasenia La contraseña.
	 * @return El nombre de la vista siguiente.
	 */
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
