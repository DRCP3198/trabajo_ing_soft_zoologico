package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Servicio;
import com.example.demo.repository.IServicioRepository;

@Service
public class ServicioServiceImpl implements IServicioService {

	@Autowired
	private IServicioRepository iServicioRepository;

	@Override
	public void agregar(Servicio servicio) {
		Servicio pEncontrado = this.iServicioRepository.encontrar(servicio.getCodigo());

		if (pEncontrado == null) {
			servicio.setEstado("Disponible");
			this.iServicioRepository.insertar(servicio);
		} else {
			 BigDecimal cantidadDia = new BigDecimal(Math.random());
			BigDecimal cantidadNueva = servicio.getValorPorDia();

			BigDecimal cantidadActualizado = cantidadNueva.multiply(cantidadDia);
			pEncontrado.setValorPorDia(cantidadActualizado);
			this.iServicioRepository.actualizar(servicio);
		}

	}

	@Override
	public void modificar(Servicio servicio) {
		this.iServicioRepository.actualizar(servicio);

	}

	@Override
	public Servicio buscar(String codigo) {
		// TODO Auto-generated method stub
		return this.iServicioRepository.encontrar(codigo);
	}

	@Override
	public void borrar(String codigo) {
		// TODO Auto-generated method stub
		this.iServicioRepository.eliminar(codigo);
	}

	@Override
	public List<Servicio> reporte() {
		// TODO Auto-generated method stub
		return this.iServicioRepository.encontrarTodos();
	}

}
