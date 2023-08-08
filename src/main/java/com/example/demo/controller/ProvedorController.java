package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.modelo.Proveedor;
import com.example.demo.service.IProveedorService;

public class ProvedorController {
	
	@Autowired IProveedorService proveedorService;
	
	@GetMapping("/almacen/lista")
	public String listaAlmacenes(Model model) {
		List<Proveedor> proveedores = (List<Proveedor>) proveedorService.buscar(null);
		model.addAttribute("proveedores", proveedores);
		return "proveedor";
	}

	@PostMapping("/proveedor/agregar")
	public String agregarAlmacen(Proveedor proveedor) {
		proveedorService.agregar(proveedor);
		return "redirect:/proveedor/lista";
	}

	@PostMapping("/proveedor/editar")
	public String guardarEdicionAlmacen(Proveedor proveedor) {
		proveedorService.modificar(proveedor);
		return "redirect:/proveedor/lista";
	}

	@GetMapping("/proveedor/eliminar/{codigo}")
	public String eliminarAlmacen(@PathVariable String codigo) {
		proveedorService.borrar(codigo);
	    return "redirect:/proveedor/lista"; 
	}

	@GetMapping("/proveedor/editar/{codigo}")
	public String mostrarFormularioEdicion(@PathVariable String codigo, Model model) {
		Proveedor proveedor = proveedorService.buscar(codigo);
		model.addAttribute("proveedor", proveedor);
		return "editar_proveedor";
	}




}
