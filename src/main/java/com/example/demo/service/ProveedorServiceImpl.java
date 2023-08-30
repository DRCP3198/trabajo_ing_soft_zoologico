package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Proveedor;
import com.example.demo.repository.IProveedorRepo;

/**
 * Implementación del servicio para la gestión de proveedores.
 */
@Service
public class ProveedorServiceImpl implements IProveedorService {

    @Autowired
    private IProveedorRepo proveedorRepo;

    /**
     * Agrega un proveedor a la base de datos.
     *
     * @param proveedor El proveedor a agregar.
     */
    @Override
    public void agregar(Proveedor proveedor) {
        this.proveedorRepo.insertar(proveedor);
    }

    /**
     * Modifica un proveedor existente en la base de datos.
     *
     * @param proveedor El proveedor a modificar.
     */
    @Override
    public void modificar(Proveedor proveedor) {
        this.proveedorRepo.actualizar(proveedor);
    }

    /**
     * Busca un proveedor por su código en la base de datos.
     *
     * @param codigo El código del proveedor a buscar.
     * @return El proveedor encontrado, o null si no se encuentra.
     */
    @Override
    public Proveedor buscar(String codigo) {
        return this.proveedorRepo.encontrar(codigo);
    }

    /**
     * Elimina un proveedor de la base de datos por su código.
     *
     * @param codigo El código del proveedor a eliminar.
     */
    @Override
    public void borrar(String codigo) {
        this.proveedorRepo.eliminar(codigo);
    }

    /**
     * Obtiene una lista de todos los proveedores en la base de datos.
     *
     * @return Una lista de proveedores.
     */
    @Override
    public List<Proveedor> reporte() {
        return this.proveedorRepo.encontrarTodos();
    }
}

