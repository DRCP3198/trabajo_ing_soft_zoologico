package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Cliente;
import com.example.demo.service.IClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/registro")
	public String registro(Cliente cliente) {
		return "registroCliente";
	}
	@PostMapping("/insertar")
	public String insertarCliente(Cliente cliente) {
		this.clienteService.agregar(cliente);
		return "redirect:/clientes/registro";
	}

}
