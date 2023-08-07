package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Almacen;
import com.example.demo.service.IAlmacenService;

@Controller
public class AlmacenController {

	@Autowired
	private IAlmacenService almacenService;

	@GetMapping("/almacen/lista")
	public String listaAlmacenes(Model model) {
		List<Almacen> almacenes = almacenService.encontrarTodos();
		model.addAttribute("almacenes", almacenes);
		return "almacen";
	}

	@PostMapping("/almacen/agregar")
	public String agregarAlmacen(Almacen almacen) {
		almacenService.agregar(almacen);
		return "redirect:/almacen/lista";
	}

	@PostMapping("/almacen/editar")
	public String guardarEdicionAlmacen(Almacen almacen) {
		almacenService.modificar(almacen);
		return "redirect:/almacen/lista";
	}

	@GetMapping("/almacen/eliminar/{nombre}")
	public String eliminarAlmacen(@PathVariable String nombre) {
	    almacenService.borrar(nombre);
	    return "redirect:/almacen/lista"; 
	}

	@GetMapping("/almacen/editar/{nombre}")
	public String mostrarFormularioEdicion(@PathVariable String nombre, Model model) {
		Almacen almacen = almacenService.encontrar(nombre);
		model.addAttribute("almacen", almacen);
		return "editar_almacen";
	}

	@PostMapping("/almacen/editar/{nombre}")
	public String guardarCambios(@PathVariable String nombre, Almacen almacenModificado) {
	    Almacen almacenExistente = almacenService.encontrar(nombre);
	    if (almacenExistente != null) {
	        almacenExistente.setNombre(almacenModificado.getNombre());
	        almacenExistente.setCapacidad(almacenModificado.getCapacidad());
	        almacenService.modificar(almacenExistente);
	    }
	    return "redirect:/almacen/lista"; 
	}

}
