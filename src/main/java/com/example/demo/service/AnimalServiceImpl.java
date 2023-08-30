package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Animal;
import com.example.demo.repository.IAnimalRepo;

/**
 * Implementación del servicio para gestionar los Animales.
 */
@Service
public class AnimalServiceImpl implements IAnimalService {

	@Autowired
	private IAnimalRepo animalRepo;

	/**
	 * Agrega un nuevo Animal.
	 *
	 * @param animal El Animal a agregar.
	 */
	@Override
	public void agregar(Animal animal) {
		this.animalRepo.insertar(animal);
	}

	/**
	 * Actualiza un Animal existente.
	 *
	 * @param animal El Animal con los detalles actualizados.
	 */
	@Override
	public void actualizar(Animal animal) {
		this.animalRepo.actualizar(animal);
	}

	/**
	 * Elimina un Animal por su nombre común.
	 *
	 * @param nombreComun El nombre común del Animal a eliminar.
	 */
	@Override
	public void eliminar(String nombreComun) {
		this.animalRepo.eliminar(nombreComun);
	}

	/**
	 * Busca y devuelve un Animal por su nombre común.
	 *
	 * @param nombreComun El nombre común del Animal a buscar.
	 * @return El Animal encontrado.
	 */
	@Override
	public Animal buscar(String nombreComun) {
		return this.animalRepo.seleccionar(nombreComun);
	}

	/**
	 * Busca y devuelve una lista de todos los Animales.
	 *
	 * @return Una lista de todos los Animales.
	 */
	@Override
	public List<Animal> buscarTodos() {
		return this.animalRepo.encontrarTodos();
	}

	/**
	 * Busca y devuelve un Animal por su ID.
	 *
	 * @param id El ID del Animal a buscar.
	 * @return El Animal encontrado.
	 */
	@Override
	public Animal buscarPorId(Integer id) {
		return this.animalRepo.buscarPorId(id);
	}

	/**
	 * Borra un Animal por su ID.
	 *
	 * @param id El ID del Animal a borrar.
	 */
	@Override
	public void borrarPorID(Integer id) {
		this.animalRepo.eliminarPorID(id);
	}
}

