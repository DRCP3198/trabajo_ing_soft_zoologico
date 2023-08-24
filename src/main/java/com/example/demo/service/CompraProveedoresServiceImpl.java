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

@Service
public class CompraProveedoresServiceImpl implements ICompraProveedoresService{

	@Autowired
	private ICompraProveedoresRepo compraProveedoresRepo;
	
	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IProveedorService iProveedorService;
	
	@Override
	public void insertar(CompraProveedores compraProveedores) {
		// TODO Auto-generated method stub
		Proveedor proveedor=this.iProveedorService.buscar(compraProveedores.getProveedor().getCodigo());
		Producto producto=this.iProductoService.buscar(compraProveedores.getProducto().getCodigo());
		
		//Actualizacion de Stock
		int stockActual=producto.getCantidad_stock();
		int stockNuevo=stockActual+compraProveedores.getCantidad();
		producto.setCantidad_stock(stockNuevo);
		this.iProductoService.modificar(producto);
		
		
		CompraProveedores compra=new CompraProveedores();
		compra.setProducto(producto);
		compra.setProveedor(proveedor);
		compra.setCantidad(compraProveedores.getCantidad());
		compra.setFechaCompra(LocalDate.now());
		//Calculo de precio de compra
		compra.setValorCompra(producto.getPrecio().multiply(new BigDecimal(compraProveedores.getCantidad())));
		
		
		
		
		this.compraProveedoresRepo.insertar(compra);
	}

	@Override
	public List<CompraProveedores> buscarTodos() {
		// TODO Auto-generated method stub
		return this.compraProveedoresRepo.buscarTodos();
	}

	@Override
	public void actualizar(CompraProveedores compraProveedores) {
		// TODO Auto-generated method stub
		this.compraProveedoresRepo.actualizar(compraProveedores);
	}

}
