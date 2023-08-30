package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Almacen;
import com.example.demo.repository.IAlmacenRepo;

/**
 * Implementación del servicio para gestionar los Almacenes.
 */
@Service
public class AlmacenServiceImpl implements IAlmacenService {

	@Autowired
	private IAlmacenRepo almacenRepo;

	/**
	 * Agrega un nuevo Almacen.
	 *
	 * @param almacen El Almacen a agregar.
	 */
	@Override
	public void agregar(Almacen almacen) {
		this.almacenRepo.insertar(almacen);
	}

	/**
	 * Modifica un Almacen existente.
	 *
	 * @param almacen El Almacen con los detalles actualizados.
	 */
	@Override
	public void modificar(Almacen almacen) {
		this.almacenRepo.actualizar(almacen);
	}

	/**
	 * Busca y devuelve un Almacen por su nombre.
	 *
	 * @param nombre El nombre del Almacen a buscar.
	 * @return El Almacen encontrado.
	 */
	@Override
	public Almacen encontrar(String nombre) {
		return this.almacenRepo.buscar(nombre);
	}

	/**
	 * Borra un Almacen por su nombre.
	 *
	 * @param nombre El nombre del Almacen a borrar.
	 */
	@Override
	public void borrar(String nombre) {
		this.almacenRepo.eliminar(nombre);
	}

	/**
	 * Encuentra y devuelve una lista de todos los Almacenes.
	 *
	 * @return Una lista de todos los Almacenes.
	 */
	@Override
	public List<Almacen> encontrarTodos() {
		return almacenRepo.encontrarTodos();
	}

}
