package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Cliente;
import com.example.demo.service.IClienteService;

/**
 * Controlador para gestionar las operaciones relacionadas con los clientes.
 */
@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    /**
     * Muestra la vista de registro de clientes.
     *
     * @param cliente Cliente para el registro.
     * @return La vista de registroCliente.
     */
    @GetMapping("/registro")
    public String registro(Cliente cliente) {
        return "registroCliente";
    }

    /**
     * Inserta un nuevo cliente en la base de datos.
     *
     * @param cliente Cliente a insertar.
     * @return La vista de confirmación de registro.
     */
    @PostMapping("/insertar")
    public String insertarCliente(Cliente cliente) {
        this.clienteService.agregar(cliente);
        return "confirmacionRegistroClientesEnClientes";
    }

    /**
     * Muestra una lista de todos los clientes en la vista de reporte.
     *
     * @param model Modelo para la vista.
     * @return La vista de vistaReporteClientes.
     */
    @GetMapping("/reporte")
    public String encontrarTodos(Model model) {
        List<Cliente> lista = this.clienteService.reporte();
        model.addAttribute("clientes", lista);
        return "vistaReporteClientes";
    }

    /**
     * Busca un cliente por su ID y muestra la vista para actualizar sus datos.
     *
     * @param id     ID del cliente a buscar.
     * @param model  Modelo para la vista.
     * @return La vista de actualizarDatosCliente.
     */
    @GetMapping("/buscarID/{idCliente}")
    public String buscarId(@PathVariable("idCliente") Integer id, Model model) {
        Cliente cli = this.clienteService.buscarId(id);
        model.addAttribute("cliente", cli);
        return "actualizarDatosCliente";
    }

    /**
     * Actualiza los datos de un cliente en la base de datos.
     *
     * @param idCliente ID del cliente a actualizar.
     * @param cliente   Datos actualizados del cliente.
     * @return La vista de vistaCliente.
     */
    @PutMapping("/actualizar/{idCliente}")
    public String actualizarCliente(@PathVariable("idCliente") Integer idCliente, Cliente cliente) {
        this.clienteService.modificarCliente(cliente);
        return "vistaCliente";
    }
}
