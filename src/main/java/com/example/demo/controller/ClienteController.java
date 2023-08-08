package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Cliente;
import com.example.demo.service.IClienteService;


@Controller
@RequestMapping("/clientes") // URL: http://localhost:8085/clientes/visualizar
								// http://localhost:8085/clientes/consultar
public class ClienteController {

	

	@Autowired
	private IClienteService iClienteService;

	

	LocalDateTime hi = null;
	LocalDateTime hf = null;
	String ced = null;

	// *******************************************************************************

	@GetMapping("/registro")
	public String paginaInicio(Cliente cliente) {
		return "vRegistroClienteC";
	}

	@PostMapping("/insertar")
	public String insertarCliente(Cliente cliente) {
		this.iClienteService.agregar(cliente);
		return "guardado";
	}

}
