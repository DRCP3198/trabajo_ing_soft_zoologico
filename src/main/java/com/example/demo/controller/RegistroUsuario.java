package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Cliente;
import com.example.demo.service.IClienteService;

@Controller
@RequestMapping("/registro")
public class RegistroUsuario {
	
	@Autowired
	private IClienteService iClienteService;
	
	
	
	public RegistroUsuario(IClienteService iClienteService) {
		super();
		this.iClienteService = iClienteService;
	}
	@ModelAttribute("cliente")
	public Cliente retornaRegistro() {
		return new Cliente();
	}
	@GetMapping
	public String formularioRegistro() {
		return "registro";
	}
	@PostMapping
	public String insertarCliente(@ModelAttribute("cliente") Cliente clienteRegistro) {
		this.iClienteService.agregar(clienteRegistro);
		return "redirect:/registro?exito";
	}
	

}
