package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Cliente;
import com.example.demo.service.IClienteService;
import com.example.demo.service.IEmpleadoService;

@Controller
@RequestMapping("/inicio")
public class PrincipalControler {
	
	@Autowired
	private IEmpleadoService empleadoService;
	
	@Autowired
	private IClienteService clienteService;
	
	
	@GetMapping("")
	public String inicio(Cliente cliente) {
		return "Login";
	}
	
	
	@GetMapping("/sesion")
		public String paginaInicio(Cliente cliente) {
			return this.empleadoService.siguienteVista(cliente.getUsuarioGeneral(), cliente.getContrasenia());
		
	}

}
