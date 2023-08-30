package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
import com.example.demo.modelo.HistorialClinico;
import com.example.demo.modelo.Producto;
import com.example.demo.modelo.Proveedor;
import com.example.demo.modelo.citaHistorialClinico;
import com.example.demo.service.IAlmacenService;
import com.example.demo.service.IAnimalService;
import com.example.demo.service.IClienteService;
import com.example.demo.service.ICompraProveedoresService;
import com.example.demo.service.IEmpleadoService;
import com.example.demo.service.IHabitatService;
import com.example.demo.service.IHistorialClinicoService;
import com.example.demo.service.IProductoService;
import com.example.demo.service.IProveedorService;
import com.example.demo.service.IcitaHistorialClinicoService;

import jakarta.validation.Valid;

/**
 * Controlador para gestionar las operaciones relacionadas con los empleados.
 */
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
    
    @Autowired
    private IcitaHistorialClinicoService citasHistorialclinicoService;
    
    @Autowired
    private IHistorialClinicoService clinicoService;

    // ... (omitiendo otras inyecciones)

    /**
     * Muestra la vista de registro de empleados.
     *
     * @param empleado Empleado para el registro.
     * @return La vista de registroEmpleado.
     */
    @GetMapping("/registro")
    public String registrarEmpleado(Empleado empleado) {
        return "resgitroEmpleado";
    }

    /**
     * Inserta un nuevo empleado en la base de datos.
     *
     * @param empleado Empleado a insertar.
     * @return La vista de confirmación de registro.
     */
    @PostMapping("/insertar")
    public String guardarRegistro(Empleado empleado) {
        this.empleadoService.agregar(empleado);
        return "confirmacionRegistroEmpleados";
    }

    /**
     * Muestra una lista de todos los empleados en la vista de reporte.
     *
     * @param model Modelo para la vista.
     * @return La vista de vistaReporteEmpleado.
     */
    @GetMapping("/reporte")
    public String reporteEmpleado(Model model) {
        List<Empleado> lista = this.empleadoService.reporte();
        model.addAttribute("empleados", lista);
        return "vistaReporteEmpleado";
    }

    // ... (omitiendo otros métodos)

    /**
     * Elimina un cliente por su ID de la base de datos.
     *
     * @param id ID del cliente a eliminar.
     * @return Redirige a la vista de reporte de clientes.
     */
    @DeleteMapping("/borrar/{idCliente}")
    public String borrarCliente(@PathVariable("idCliente")Integer id) {
        this.clienteService.eliminar(id);
        return "redirect:/empleados/cliente/reporte";
    }

    // ... (omitiendo otros métodos)

    /**
     * Muestra la vista de registro de nuevos animales.
     *
     * @param animal Animal para el registro.
     * @return La vista de vistaNuevoAnimal.
     */
    @GetMapping("animal/registro")
    public String registrarAnimal(Animal animal) {
        return "vistaNuevoAnimal";
    }

    // ... (omitiendo otros métodos)

    /**
     * Elimina un animal por su ID de la base de datos.
     *
     * @param id ID del animal a eliminar.
     * @return Redirige a la vista de lista de animales.
     */
    @DeleteMapping("/eliminar/{id}")
    public String eliminarAnimal(@PathVariable("id") Integer id) {
        this.animalService.borrarPorID(id);
        return "redirect:/empleados/listaAnimales";
    }

    // ... (omitiendo otros métodos)

    /**
     * Muestra la vista de registro de nuevos productos.
     *
     * @param producto Producto para el registro.
     * @return La vista de vistaNuevoProducto.
     */
    @GetMapping("producto/registro")
    public String registrarProducto(Producto producto) {
        return "vistaNuevoProducto";
    }

    // ... (omitiendo otros métodos)

    /**
     * Elimina un producto por su código de la base de datos.
     *
     * @param codigo Código del producto a eliminar.
     * @return Redirige a la vista de lista de productos.
     */
    @DeleteMapping("/producto/eliminar/{codigo}")
    public String eliminarProducto(@PathVariable("codigo") String codigo) {
        this.iProductoService.borrar(codigo);
        return "redirect:/empleados/listaProductos";
    }

    // ... (omitiendo otros métodos)

    /**
     * Muestra la vista de registro de nuevos proveedores.
     *
     * @param proveedor Proveedor para el registro.
     * @return La vista de vistaNuevoProveedor.
     */
    @GetMapping("proveedor/registro")
    public String registrarProveedor(Proveedor proveedor) {
        return "vistaNuevoProveedor";
    }

    // ... (omitiendo otros métodos)

    /**
     * Elimina un proveedor por su código de la base de datos.
     *
     * @param codigo Código del proveedor a eliminar.
     * @return Redirige a la vista de lista de proveedores.
     */
    @DeleteMapping("/proveedor/eliminar/{codigo}")
    public String eliminarProveedor(@PathVariable("codigo") String codigo) {
        this.iProveedorService.borrar(codigo);
        return "redirect:/empleados/listaProveedores";
    }

    // ... (omitiendo otros métodos)

    /**
     * Muestra la vista de registro de una nueva compra para un proveedor.
     *
     * @param codigo          Código del proveedor para la compra.
     * @param compraProveedores CompraProveedores para el registro.
     * @param model           Modelo para la vista.
     * @return La vista de vistaNuevaCompra.
     */
    @GetMapping("compra/registro/{codigo}")
    public String registrarCompra(@PathVariable("codigo") String codigo, CompraProveedores compraProveedores,
                                  Model model) {
        Proveedor p = this.iProveedorService.buscar(codigo);
        compraProveedores.setProveedor(p);
        List<Producto> productos = this.iProductoService.reporte();
        model.addAttribute("productos", productos);
        return "vistaNuevaCompra";
    }

    // ... (omitiendo otros métodos)

    /**
     * Muestra la vista de registro de una nueva cita para un historial clínico.
     *
     * @param id                     ID del historial clínico para la cita.
     * @param citaHistorialClinico citaHistorialClinico para el registro.
     * @param model                  Modelo para la vista.
     * @return La vista de vistaNuevaCitaHistorial.
     */
    @GetMapping("/cita/registroHistorial/{id}")
    public String registrarCita(@PathVariable("id") Integer id, citaHistorialClinico citaHistorialClinico,
                                Model model) {
        HistorialClinico h = this.clinicoService.buscar(id);
        citaHistorialClinico.setHistorial_clinico(h);
        List<Animal> animales = this.animalService.buscarTodos();
        model.addAttribute("animales", animales);
        return "vistaNuevaCitaHistorial";
    }

    // ... (omitiendo otros métodos)

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

    // ... (omitiendo otros métodos)

    /**
     * Inserta un nuevo historial clínico en la base de datos.
     *
     * @param historial Historial clínico a insertar.
     * @return Redirige a la vista de lista de historiales clínicos.
     */
    @PostMapping("/insertar/historial")
    public String insertarHistorial(HistorialClinico historial) {
        this.clinicoService.realizar(historial);
        return "redirect:/empleados/listaHistorial";
    }

    // ... (omitiendo otros métodos)

    /**
     * Muestra la vista de lista de historiales clínicos.
     *
     * @param modelo Modelo para la vista.
     * @return La vista de vistaHistorial.
     */
    @GetMapping("/listaHistorial")
    public String listaAnimalesH(Model modelo) {
        List<HistorialClinico> historial = this.clinicoService.buscarTodos();
        modelo.addAttribute("historial", historial);
        return "vistaHistorial";
    }

    // ... (omitiendo otros métodos)

    /**
     * Muestra la vista de lista de almacenes.
     *
     * @param model Modelo para la vista.
     * @return La vista de almacen.
     */
    @GetMapping("/almacen/lista")
    public String listaAlmacenes(Model model) {
        List<Almacen> almacenes = almacenService.encontrarTodos();
        model.addAttribute("almacenes", almacenes);
        return "almacen";
    }

    // ... (omitiendo otros métodos)

    /**
     * Agrega un nuevo almacen a la base de datos.
     *
     * @param almacen Almacen a agregar.
     * @return Redirige a la vista de lista de almacenes.
     */
    @PostMapping("/almacen/agregar")
    public String agregarAlmacen(Almacen almacen) {
        almacenService.agregar(almacen);
        return "redirect:/empleados/almacen/lista";
    }

    // ... (omitiendo otros métodos)

    /**
     * Guarda los cambios realizados en un almacen en la base de datos.
     *
     * @param almacen Almacen modificado.
     * @return Redirige a la vista de lista de almacenes.
     */
    @PostMapping("/almacen/editar")
    public String guardarEdicionAlmacen(Almacen almacen) {
        almacenService.modificar(almacen);
        return "redirect:/empleados/almacen/lista";
    }

    // ... (omitiendo otros métodos)

    /**
     * Elimina un almacen por su nombre de la base de datos.
     *
     * @param nombre Nombre del almacen a eliminar.
     * @return Redirige a la vista de lista de almacenes.
     */
    @GetMapping("/almacen/eliminar/{nombre}")
    public String eliminarAlmacen(@PathVariable String nombre) {
        almacenService.borrar(nombre);
        return "redirect:/empleados/almacen/lista";
    }

    // ... (omitiendo otros métodos)

    /**
     * Muestra el formulario de edición de un almacen.
     *
     * @param nombre Nombre del almacen a editar.
     * @param model  Modelo para la vista.
     * @return La vista de editar_almacen.
     */
    @GetMapping("/almacen/editar/{nombre}")
    public String mostrarFormularioEdicion(@PathVariable String nombre, Model model) {
        Almacen almacen = almacenService.encontrar(nombre);
        model.addAttribute("almacen", almacen);
        return "editar_almacen";
    }

    // ... (omitiendo otros métodos)

    /**
     * Guarda los cambios realizados en un almacen en la base de datos.
     *
     * @param nombre            Nombre del almacen original.
     * @param almacenModificado Almacen con los cambios.
     * @return Redirige a la vista de lista de almacenes.
     */
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

