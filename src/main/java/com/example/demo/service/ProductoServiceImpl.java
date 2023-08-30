package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;
import com.example.demo.repository.IProductoRepo;

/**
 * Implementación del servicio para la gestión de productos.
 */
@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    private IProductoRepo productoRepo;

    /**
     * Agrega un producto a la base de datos.
     * Si el producto no existe, se agrega con el estado "Disponible".
     * Si el producto ya existe, se actualiza el stock sumando el nuevo stock al stock existente.
     *
     * @param producto El producto a agregar o actualizar.
     */
    @Override
    public void agregar(Producto producto) {
        Producto pEncontrado = this.productoRepo.encontrar(producto.getCodigo());

        if (pEncontrado == null) {
            producto.setEstado("Disponible");
            this.productoRepo.insertar(producto);
        } else {
            int stockAnterior = pEncontrado.getCantidad_stock();
            int stockNuevo = producto.getCantidad_stock();
            int stockAtualizado = stockAnterior + stockNuevo;
            pEncontrado.setCantidad_stock(stockAtualizado);
            this.productoRepo.actualizar(pEncontrado);
        }
    }

    /**
     * Modifica un producto existente en la base de datos.
     *
     * @param producto El producto a modificar.
     */
    @Override
    public void modificar(Producto producto) {
        this.productoRepo.actualizar(producto);
    }

    /**
     * Busca un producto por su código en la base de datos.
     *
     * @param codigo El código del producto a buscar.
     * @return El producto encontrado, o null si no se encuentra.
     */
    @Override
    public Producto buscar(String codigo) {
        return this.productoRepo.encontrar(codigo);
    }

    /**
     * Elimina un producto de la base de datos por su código.
     *
     * @param codigo El código del producto a eliminar.
     */
    @Override
    public void borrar(String codigo) {
        this.productoRepo.eliminar(codigo);
    }

    /**
     * Obtiene una lista de todos los productos en la base de datos.
     *
     * @return Una lista de productos.
     */
    @Override
    public List<Producto> reporte() {
        return this.productoRepo.encontrarTodos();
    }
}
