package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.CompraProveedores;
import com.example.demo.modelo.Producto;
import com.example.demo.modelo.Proveedor;
import com.example.demo.repository.ICompraProveedoresRepo;

/**
 * Implementación del servicio para gestionar las compras a proveedores.
 */
@Service
public class CompraProveedoresServiceImpl implements ICompraProveedoresService {

	@Autowired
	private ICompraProveedoresRepo compraProveedoresRepo;

	@Autowired
	private IProductoService iProductoService;

	@Autowired
	private IProveedorService iProveedorService;

	/**
	 * Registra una nueva compra a proveedores y actualiza el stock y valor del producto.
	 *
	 * @param compraProveedores La compra a proveedores a registrar.
	 */
	@Override
	public void insertar(CompraProveedores compraProveedores) {
		Proveedor proveedor = this.iProveedorService.buscar(compraProveedores.getProveedor().getCodigo());
		Producto producto = this.iProductoService.buscar(compraProveedores.getProducto().getCodigo());

		// Actualización de Stock
		int stockActual = producto.getCantidad_stock();
		int stockNuevo = stockActual + compraProveedores.getCantidad();
		producto.setCantidad_stock(stockNuevo);
		this.iProductoService.modificar(producto);

		CompraProveedores compra = new CompraProveedores();
		compra.setProducto(producto);
		compra.setProveedor(proveedor);
		compra.setCantidad(compraProveedores.getCantidad());
		compra.setFechaCompra(LocalDate.now());

		// Cálculo de precio de compra
		compra.setValorCompra(producto.getPrecio().multiply(new BigDecimal(compraProveedores.getCantidad())));

		this.compraProveedoresRepo.insertar(compra);
	}

	/**
	 * Recupera una lista de todas las compras a proveedores.
	 *
	 * @return Una lista de las compras a proveedores.
	 */
	@Override
	public List<CompraProveedores> buscarTodos() {
		return this.compraProveedoresRepo.buscarTodos();
	}

	/**
	 * Actualiza los detalles de una compra a proveedores.
	 *
	 * @param compraProveedores La compra a proveedores con los detalles actualizados.
	 */
	@Override
	public void actualizar(CompraProveedores compraProveedores) {
		this.compraProveedoresRepo.actualizar(compraProveedores);
	}
}
