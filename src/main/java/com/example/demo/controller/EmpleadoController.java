package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Almacen;
import com.example.demo.modelo.Animal;
import com.example.demo.modelo.Cliente;
import com.example.demo.modelo.CompraProveedores;
import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Producto;
import com.example.demo.modelo.Proveedor;
import com.example.demo.service.IAlmacenService;
import com.example.demo.service.IAnimalService;
import com.example.demo.service.IClienteService;
import com.example.demo.service.ICompraProveedoresService;
import com.example.demo.service.IEmpleadoService;
import com.example.demo.service.IHabitatService;
import com.example.demo.service.IProductoService;
import com.example.demo.service.IProveedorService;

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

	@Autowired
	private IProductoService iProductoService;

	@Autowired
	private IProveedorService iProveedorService;

	@Autowired
	private ICompraProveedoresService compraProveedoresService;


	// Empleado
	@GetMapping("/registro")
	public String registrarEmpleado(Empleado empleado) {
		return "resgitroEmpleado";
	}

	@PostMapping("/insertar")
	public String guardarRegistro(Empleado empleado) {
		this.empleadoService.agregar(empleado);
		return "redirect:/empleados/registro";
	}

	@GetMapping("/reporte")
	public String reporteEmpleado(Model model) {
		List<Empleado> lista = this.empleadoService.reporte();
		model.addAttribute("empleados", lista);
		return "vistaReporteEmpleado";
	}

	// CLIENTE
	// registro cliente
	@GetMapping("/cliente/registro")
	public String registraCliente(Cliente cliente) {
		return "vistaRegistroClienteEmpl";
	}

	@PostMapping("/insertar/cliente")
	public String insertarCliente(Cliente cliente) {
		this.clienteService.agregar(cliente);
		return "confirmacionRegistroEmpleado";
	}

	@GetMapping("/confir")
	public String confir() {
		return "confirmacionRegistroEmpleado";
	}

	// http://localhost:8085/zoologico/empleados/cliente/reporte
	@GetMapping("/cliente/reporte")
	public String reporteCliente(Model model) {
		List<Cliente> lista = this.clienteService.reporte();
		model.addAttribute("clientes", lista);
		return "vistaReporteClientesEmpleado";
	}

	@GetMapping("/cliente/buscarPorID/{idCliente}")
	public String buscarPorId(@PathVariable("idCliente") Integer id, Model model) {
		Cliente cliente = this.clienteService.buscarId(id);
		model.addAttribute("cliente", cliente);
		return "actualizarDatosCliente";
	}

	@PutMapping("/actualizar/{idCliente}")
	public String actualizarCliente(@PathVariable("idCliente") Integer id, Cliente cliente) {
		this.clienteService.modificarCliente(cliente);
		return "redirect:/empleados/cliente/reporte";

	}
	@DeleteMapping("/borrar/{idCliente}")
	public String borrarCliente(@PathVariable("idCliente")Integer id) {
		this.clienteService.eliminar(id);
		return "redirect:/empleados/cliente/reporte";
		
	}

	// ANIMALES
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
		List<Animal> animales = this.animalService.buscarTodos();
		modelo.addAttribute("animales", animales);
		return "vistaListaAnimales";
	}

	@DeleteMapping("/eliminar/{id}")
	public String eliminarAnimal(@PathVariable("id") Integer id) {
		this.animalService.borrarPorID(id);
		return "redirect:/empleados/listaAnimales";
	}

	// PRODUCTO
	@GetMapping("producto/registro")
	public String registrarProducto(Producto producto) {
		return "vistaNuevoProducto";
	}

	@PostMapping("/insertar/producto")
	public String insertarProducto(Producto producto) {
		this.iProductoService.agregar(producto);
		return "redirect:/empleados/producto/registro";
	}

	@GetMapping("/listaProductos")
	public String listaProductos(Model modelo) {
		List<Producto> productos = this.iProductoService.reporte();
		modelo.addAttribute("productos", productos);
		return "vistaListaProductos";
	}

	@DeleteMapping("/producto/eliminar/{codigo}")
	public String eliminarProducto(@PathVariable("codigo") String codigo) {
		this.iProductoService.borrar(codigo);
		return "redirect:/empleados/listaProductos";
	}

	// PROVEEDOR
	@GetMapping("proveedor/registro")
	public String registrarProveedor(Proveedor proveedor) {
		return "vistaNuevoProveedor";
	}

	@PostMapping("/insertar/proveedor")
	public String insertarProducto(Proveedor proveedor) {
		this.iProveedorService.agregar(proveedor);
		return "redirect:/empleados/proveedor/registro";
	}

	@GetMapping("/listaProveedores")
	public String listaProveedores(Model modelo) {
		List<Proveedor> proveedores = this.iProveedorService.reporte();
		modelo.addAttribute("proveedores", proveedores);
		return "vistaListaProveedores";
	}

	@DeleteMapping("/proveedor/eliminar/{codigo}")
	public String eliminarProveedor(@PathVariable("codigo") String codigo) {
		this.iProveedorService.borrar(codigo);
		return "redirect:/empleados/listaProveedores";
	}

	// COMPRA
	@GetMapping("compra/registro/{codigo}")
	public String registrarCompra(@PathVariable("codigo") String codigo, CompraProveedores compraProveedores,
			Model modelo) {
		Proveedor p = this.iProveedorService.buscar(codigo);
		compraProveedores.setProveedor(p);
		List<Producto> productos = this.iProductoService.reporte();
		modelo.addAttribute("productos", productos);
		return "vistaNuevaCompra";
	}

	@PostMapping("/insertar/compra")
	public String insertarCompra(CompraProveedores compraProveedores) {
		this.compraProveedoresService.insertar(compraProveedores);
		return "redirect:/empleados/listaCompras";
	}

	@GetMapping("/listaCompras")
	public String listaCompras(Model modelo) {
		List<CompraProveedores> compraProveedores = this.compraProveedoresService.buscarTodos();
		modelo.addAttribute("compraProveedores", compraProveedores);
		return "vistaListaCompras";
	}

	// ALMACEN
	// http://localhost:8085/zoologico/empleados/almacen/lista
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

	@PostMapping("/almacen/editar")
	public String guardarEdicionAlmacen(Almacen almacen) {
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
		return "redirect:/empleados/almacen/lista";
	}

}
