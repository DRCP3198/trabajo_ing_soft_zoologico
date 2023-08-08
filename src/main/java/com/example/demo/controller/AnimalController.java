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
import com.example.demo.service.IAnimalService;

@Controller
@RequestMapping("/animales")
public class AnimalController {
	
	@Autowired
	private IAnimalService animalService;
	
	@GetMapping("/registrarAnimal")
	public String registrarAnimal(Animal animal) {
		return "vistaNuevoAnimal";
	}
	
	@PostMapping("/insertar")
	public String insertarAnimal(Animal animal) {
		this.animalService.agregar(animal);
		return "redirect:/animales/listaAnimales";
	}
	
	@GetMapping("/listaAnimales")
	public String listaAnimales(Model modelo) {
		List<Animal> animales=this.animalService.buscarTodos();
		modelo.addAttribute("animales",animales);
		return "vistaListaAnimales";
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarAnimal(@PathVariable("id")Integer id) {
		this.animalService.borrarPorID(id);
		return "redirect:/animales/listaAnimales";
	}

}
