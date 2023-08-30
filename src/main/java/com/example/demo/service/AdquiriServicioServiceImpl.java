package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.AdquirirServicioProveedor;
import com.example.demo.modelo.ProveedorServicios;
import com.example.demo.modelo.Servicio;
import com.example.demo.repository.IAdquiriServicioRepo;

@Service
public class AdquiriServicioServiceImpl implements IAdquiriServicioRepo{

	@Autowired
	private IAdquiriServicioRepo adquiriServicioRepo;
	
	@Autowired
	private IServicioService iServicioService;
	
	@Autowired
	private IProveedorServiciosService iProveedorServiciosService;
	
	
	
	@Override
	public void insertar(AdquirirServicioProveedor adquirirServicioProveedor) {
		// TODO Auto-generated method stub
		ProveedorServicios proveedor = this.iProveedorServiciosService.buscar(adquirirServicioProveedor.getProveedorServicios().getCodigo());
		Servicio servicio = this.iServicioService.buscar(adquirirServicioProveedor.getServicio().getCodigo());
		
		BigDecimal cantidadActual = servicio.getValorPorDia();
		BigDecimal cantidadNueva = cantidadActual.add(adquirirServicioProveedor.getValor());
		servicio.setValorPorDia(cantidadNueva);
		this.iServicioService.modificar(servicio);
		
		AdquirirServicioProveedor adquirir = new AdquirirServicioProveedor();
		adquirir.setServicio(servicio);
		adquirir.setProveedorServicios(proveedor);
		adquirir.setValor(adquirirServicioProveedor.getValor());
		adquirir.setFechaAdquisicion(LocalDate.now());
		
		this.adquiriServicioRepo.insertar(adquirirServicioProveedor);
		
	}

	@Override
	public List<AdquirirServicioProveedor> buscarTodos() {
		// TODO Auto-generated method stub
		return this.adquiriServicioRepo.buscarTodos();
	}

	@Override
	public void actualizar(AdquirirServicioProveedor adquirirServicioProveedor) {
		// TODO Auto-generated method stub
		this.adquiriServicioRepo.actualizar(adquirirServicioProveedor);
	}

}
