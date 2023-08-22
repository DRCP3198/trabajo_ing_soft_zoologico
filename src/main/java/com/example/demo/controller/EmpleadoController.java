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

import com.example.demo.modelo.Almacen;
import com.example.demo.modelo.Animal;
import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.Empleado;
import com.example.demo.service.IAlmacenService;
import com.example.demo.service.IAnimalService;
import com.example.demo.service.IClienteService;
import com.example.demo.service.IEmpleadoService;
import com.example.demo.service.IHabitatService;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

	@Autowired
	private IEmpleadoService empleadoService;

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IAnimalService animalService;
	
	@Autowired
	private IHabitatService habitatService;
	
	@Autowired
	private IAlmacenService almacenService;

	@GetMapping("/registro")
	public String registrarEmpleado(Empleado empleado) {
		return "resgitroEmpleado";
	}

	@PostMapping("/insertar")
	public String guardarRegistro(Empleado empleado) {
		this.empleadoService.agregar(empleado);
		return "redirect:/empleados/registro";
	}
     
	//CLIENTE
	// registro cliente
	@GetMapping("/cliente/registro")
	public String registraCliente(Cliente cliente) {
		return "vistaRegistroClienteEmpl";
	}
	@PostMapping("/insertar/cliente")
	public String insertarCliente(Cliente cliente) {
		this.clienteService.agregar(cliente);
		return "redirect:/empleados/cliente/registro";
	} 
	
	//ANIMALES
	@GetMapping("animal/registro")
	public String registrarAnimal(Animal animal) {
		return "vistaNuevoAnimal";
	}
	@PostMapping("/insertar/animal")
	public String insertarAnimal(Animal animal) {
		this.animalService.agregar(animal);
		return "redirect:/empleados/animal/registro";
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
		return "redirect:/empleados/listaAnimales";
	}
	//ALMACEN
	//http://localhost:8085/zoologico/empleados/almacen/lista
		@GetMapping("/almacen/lista")
		public String listaAlmacenes(Model model) {
			List<Almacen> almacenes = almacenService.encontrarTodos();
			model.addAttribute("almacenes", almacenes);
			return "almacen";
		}

		@PostMapping("/almacen/agregar")
		public String agregarAlmacen(Almacen almacen) {
			almacenService.agregar(almacen);
			return "redirect:/empleados/almacen/lista";
		}
		
		

		@PostMapping("/almacen/editarAlmacen/{nombre}")
		public String guardarEdicionAlmacen(@PathVariable String nombre,Almacen almacen) {
			almacenService.modificar(almacen);
			return "redirect:/empleados/almacen/lista";
		}

		@GetMapping("/almacen/eliminar/{nombre}")
		public String eliminarAlmacen(@PathVariable String nombre) {
		    almacenService.borrar(nombre);
		    return "redirect:/empleados/almacen/lista"; 
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
		        almacenExistente.setTipo(almacenModificado.getTipo());
		        almacenService.modificar(almacenExistente);
		    }
		    return "redirect:/almacen/lista"; 
		}

}
