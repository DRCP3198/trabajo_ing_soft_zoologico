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

import com.example.demo.modelo.Habitat;
import com.example.demo.service.IHabitatService;

/**
 * Este controlador maneja las operaciones relacionadas con los hábitats.
 */

@Controller
@RequestMapping("/habitats")
public class HabitadController {
	
	@Autowired
	private IHabitatService habitatService;
	
	/**
	 * Muestra la vista de registro de un nuevo hábitat.
	 *
	 * @param model Modelo para la vista.
	 * @return La vista de vistaNuevoHabitat.
	 */
	@GetMapping("/registrarHabitat")
	public String registrarHistorial(Model model) {
	    Habitat habitat = new Habitat();// Crear una instancia de Habitat
	    model.addAttribute("habitat", habitat); // Agregar el objeto habitat al modelo
	    return "vistaNuevoHabitat"; // Retornar la vista
	}
	
	/**
	 * Inserta un nuevo hábitat en la base de datos.
	 *
	 * @param habitat Hábitat a insertar.
	 * @return Redirige a la vista de lista de hábitats.
	 */
	@PostMapping("/insertar")
	public String insertarAnimal(Habitat habitat) {
		this.habitatService.agregar(habitat);
		return "redirect:/habitats/listaHabitats";
	}
	
	/**
	 * Muestra la vista de lista de hábitats.
	 *
	 * @param modelo Modelo para la vista.
	 * @return La vista de vistaListaHabitats.
	 */
	@GetMapping("/listaHabitats")
	public String listaHabitats(Model modelo) {
		List<Habitat> habitats=this.habitatService.encontrarTodos();
		modelo.addAttribute("habitats",habitats);
		return "vistaListaHabitats";
	}
	
	/**
	 * Elimina un hábitat por su ID de la base de datos.
	 *
	 * @param id ID del hábitat a eliminar.
	 * @return Redirige a la vista de lista de hábitats.
	 */
	@DeleteMapping("/eliminar/{id}")
	public String eliminarHabitat(@PathVariable("id")Integer id) {
		this.habitatService.eliminarPorId(id);
		return "redirect:/habitats/listaHabitats";
	}

}
