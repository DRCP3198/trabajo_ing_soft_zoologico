package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Cliente;
import com.example.demo.service.IClienteService;
import com.example.demo.service.IEmpleadoService;


/**
 * Este controlador maneja la página de inicio de sesión y el enrutamiento después del inicio de sesión.
 */

@Controller
@RequestMapping("/inicio")
public class PrincipalControler {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private IClienteService clienteService;
	
	/**
	 * Muestra la página de inicio de sesión.
	 *
	 * @param cliente Cliente para la vista (puede ser nulo).
	 * @return La vista "Login".
	 */
	@GetMapping("")
	public String inicio(Cliente cliente) {
		return "Login";
	}
	
	/**
	 * Maneja el inicio de sesión y redirige a la página correspondiente.
	 *
	 * @param cliente Cliente con los datos de inicio de sesión.
	 * @return La vista correspondiente según el resultado del inicio de sesión.
	 */
	@GetMapping("/sesion")
	public String paginaInicio(Cliente cliente) {
		// Se llama al servicio de empleado para determinar la vista siguiente.
		return this.empleadoService.siguienteVista(cliente.getUsuarioGeneral(), cliente.getContrasenia());
	}
}

