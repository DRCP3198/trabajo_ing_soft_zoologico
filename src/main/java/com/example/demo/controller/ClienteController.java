package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping("/actualizar/{id}")
	public String actualizarCliente(@PathVariable("id")Integer id,Model model) {
		Cliente cliente = this.clienteService.buscarId(id);
		model.addAttribute("cliente", cliente);
		model.addAttribute("id", id);
		return "actualizarDatosCliente";
	}
	@PutMapping("/actualizar/cliente/{id}")
	public String actualizarPorIdCliente(@PathVariable("id") Integer id, Cliente cliente) {
		cliente.setId(id);

		this.clienteService.modificarCliente(cliente);

		return "redirect:/clientes/inicio";
	}

}
