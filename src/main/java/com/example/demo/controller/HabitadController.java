package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Animal;
import com.example.demo.modelo.Habitat;
import com.example.demo.modelo.HistorialClinico;
import com.example.demo.service.IHabitatService;

@Controller
@RequestMapping("/habitats")
public class HabitadController {
	
	@Autowired
	private IHabitatService habitatService;
	
	@GetMapping("/registrarHabitat")
	public String registrarHistorial(Model model) {
	    Habitat habitat = new Habitat();// Crear una instancia de HistorialClinico
	    model.addAttribute("habitat", habitat); // Agregar el objeto historial al modelo
	    return "vistaNuevoHabitat"; // Retornar la vista
	}
	
	@PostMapping("/insertar")
	public String insertarAnimal(Habitat habitat) {
		this.habitatService.agregar(habitat);
		return "redirect:/habitats/listaHabitats";
	}
	
	@GetMapping("/listaHabitats")
	public String listaHabitats(Model modelo) {
		List<Habitat> habitats=this.habitatService.encontrarTodos();
		modelo.addAttribute("habitats",habitats);
		return "vistaListaHabitats";
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarHabitat(@PathVariable("id")Integer id) {
		this.habitatService.eliminarPorId(id);
		return "redirect:/habitats/listaHabitats";
	}

}
