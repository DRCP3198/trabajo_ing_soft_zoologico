package com.example.demo.controller;

import java.util.List;

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
		return "confirmacionRegistroClientesEnClientes";
	}

	// http://localhost:8085/zoologico/clientes/reporte
	@GetMapping("/reporte")
	public String encontrarTodos(Model model) {
		List<Cliente> lista = this.clienteService.reporte();
		model.addAttribute("clientes", lista);
		return "vistaReporteClientes";
	}

	// http://localhost:8085/zoologico/clientes/buscarID/1
	@GetMapping("/buscarID/{idCliente}")
	public String buscarId(@PathVariable("idCliente") Integer id, Model model) {
		Cliente cli = this.clienteService.buscarId(id);
		model.addAttribute("cliente", cli);
		return "actualizarDatosCliente";

	}

	@PutMapping("/actualizar/{idCliente}")
	public String actualizarCliente(@PathVariable("idCliente") Integer id, Cliente cliente) {
		this.clienteService.modificarCliente(cliente);
		return "vistaCliente";
	}

}
