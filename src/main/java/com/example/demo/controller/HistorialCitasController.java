package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.HistorialCitas;
import com.example.demo.service.IHistorialCitasService;

@Controller
@RequestMapping("/citas")
public class HistorialCitasController {

	@Autowired
	private IHistorialCitasService citasService;
	
	@GetMapping("/registrarCita")
	public String registrarHistorial(Model model) {
	   HistorialCitas cita = new HistorialCitas(); // Crear una instancia de HistorialClinico
	    model.addAttribute("cita", cita); // Agregar el objeto historial al modelo
	    return "vistaNuevaCita"; // Retornar la vista
	}
	
	@PostMapping("/insertar")
	public String insertarHistorial(HistorialCitas cita) {
		this.citasService.agregar(cita);
		return "redirect:/citas/listaCitas";
				}
	
	
	@GetMapping("/listaFehca")
	public String listaCitas(@RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fecha,
	                         Model modelo) {
	    List<HistorialCitas> cita = this.citasService.encontrar(fecha);
	    modelo.addAttribute("cita", cita);
	    return "vistaCitas";
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminarAnimal(@PathVariable("id")Integer id) {
		this.citasService.eliminar(id);
		return "redirect:/citas/listaCitas";
	}
	
	
	@GetMapping("/buscarPorId/{id}")
	public String buscarPorId(@PathVariable("id")Integer id, Model modelo) {
		HistorialCitas cita = this.citasService.buscarId(id);
		modelo.addAttribute("cita", cita);
		return "vistaCitas";
	}
	
	
	@PutMapping("/actualizar/{id}")
	public String actualizarPorId(@PathVariable("id")Integer id, HistorialCitas cita) {
		cita.setId(id);
		this.citasService.actualizar(cita);
		return "actualizarCita";
	}
	
	@GetMapping("/listaCitas")
	public String buscarTodos(Model modelo) {
		List<HistorialCitas> lista = this.citasService.buscarTodos();
		modelo.addAttribute("cita", lista);
		return "vistaCitas";
	}
}
