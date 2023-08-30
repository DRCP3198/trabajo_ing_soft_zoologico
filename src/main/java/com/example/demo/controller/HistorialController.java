package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.HistorialClinico;
import com.example.demo.service.IHistorialClinicoService;

/**
 * Este controlador maneja las operaciones relacionadas con los historiales clínicos.
 */

@Controller
@RequestMapping("/historiales")
public class HistorialController {
	
	@Autowired
	private IHistorialClinicoService clinicoService;
	
	/**
	 * Muestra la vista de registro de un nuevo historial clínico.
	 *
	 * @param model Modelo para la vista.
	 * @return La vista de vistaNuevoHistorial.
	 */
	@GetMapping("/registrarHistorial")
	public String registrarHistorial(Model model) {
	    HistorialClinico historial = new HistorialClinico(); // Crear una instancia de HistorialClinico
	    model.addAttribute("historial", historial); // Agregar el objeto historial al modelo
	    return "vistaNuevoHistorial"; // Retornar la vista
	}
	
	/**
	 * Inserta un nuevo historial clínico en la base de datos.
	 *
	 * @param historial Historial clínico a insertar.
	 * @return Redirige a la vista de registro de nuevo historial clínico.
	 */
	@PostMapping("/insertar")
	public String insertarHistorial(HistorialClinico historial) {
		this.clinicoService.realizar(historial);
		return "redirect:/historiales/registrarHistorial";
	}
}

