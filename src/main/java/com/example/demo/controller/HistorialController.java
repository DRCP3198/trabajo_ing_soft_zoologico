package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.HistorialClinico;
import com.example.demo.service.IHistorialClinicoService;

@Controller
@RequestMapping("/historiales")
public class HistorialController {
	
	@Autowired
	private IHistorialClinicoService clinicoService;
	
	@GetMapping("/registrarHistorial")
	public String registrarHistorial(Model model) {
	    HistorialClinico historial = new HistorialClinico(); // Crear una instancia de HistorialClinico
	    model.addAttribute("historial", historial); // Agregar el objeto historial al modelo
	    return "vistaNuevoHistorial"; // Retornar la vista
	}
	
	@PostMapping("/insertar")
	public String insertarHistorial(HistorialClinico historial) {
		this.clinicoService.realizar(historial);
		return "redirect:/historiales/registrarHistorial";
	}
	
	

}
