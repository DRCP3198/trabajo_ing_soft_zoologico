package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Cliente;
import com.example.demo.repository.IClienteRepo;
import com.example.demo.repository.IEmpleadoRepo;

/**
 * Implementación del servicio para gestionar los clientes.
 */
@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepo clienteRepo;

	@Autowired
	private IEmpleadoRepo empleadoRepo;

	/**
	 * Agrega un nuevo cliente.
	 *
	 * @param cliente El cliente a agregar.
	 */
	@Override
	public void agregar(Cliente cliente) {
		this.clienteRepo.insertar(cliente);
	}

	/**
	 * Modifica un cliente a través de su ID.
	 *
	 * @param id El ID del cliente a modificar.
	 */
	@Override
	public void modificar(Integer id) {
		this.clienteRepo.actualizar(id);
	}

	/**
	 * Busca un cliente por su número de cédula.
	 *
	 * @param cedula La cédula del cliente a buscar.
	 * @return El cliente encontrado o null si no existe.
	 */
	@Override
	public Cliente buscar(String cedula) {
		return this.clienteRepo.encontrarCedula(cedula);
	}

	/**
	 * Obtiene una lista de todos los clientes.
	 *
	 * @return Una lista de todos los clientes.
	 */
	@Override
	public List<Cliente> reporte() {
		return this.clienteRepo.encontrarTodos();
	}

	/**
	 * Autentica un cliente por su usuario y contraseña.
	 *
	 * @param user El nombre de usuario del cliente.
	 * @param pass La contraseña del cliente.
	 * @return true si la autenticación es exitosa, false si no lo es.
	 */
	@Override
	public Boolean autenticar(String user, String pass) {
		Cliente cliente = this.clienteRepo.encontrarUsuario(user);
		if (cliente == null) {
			return false;
		} else {
			return cliente.getContrasenia().equals(pass);
		}
	}

	/**
	 * Verifica la autenticación y redirecciona a la vista correspondiente.
	 *
	 * @param user El nombre de usuario del cliente.
	 * @param pass La contraseña del cliente.
	 * @return El nombre de la vista a redireccionar.
	 */
	public String siguienteVistaCliente(String user, String pass) {
		if (this.autenticar(user, pass)) {
			return "vistaCliente";
		} else {
			return "redirect:/inicio";
		}
	}

	/**
	 * Modifica los detalles de un cliente.
	 *
	 * @param cliente El cliente con los detalles actualizados.
	 */
	@Override
	public void modificarCliente(Cliente cliente) {
		this.clienteRepo.actualizarCliente(cliente);
	}

	/**
	 * Busca un cliente por su ID.
	 *
	 * @param id El ID del cliente a buscar.
	 * @return El cliente encontrado o null si no existe.
	 */
	@Override
	public Cliente buscarId(Integer id) {
		return this.clienteRepo.encontrarId(id);
	}

	/**
	 * Elimina un cliente por su ID.
	 *
	 * @param id El ID del cliente a eliminar.
	 */
	@Override
	public void eliminar(Integer id) {
		this.clienteRepo.eliminar(id);
	}
}
