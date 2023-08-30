package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Habitat;
import com.example.demo.repository.IHabitatRepo;

/**
 * Implementación del servicio para gestionar hábitats.
 */
@Service
public class HabitatServiceImpl implements IHabitatService {

	@Autowired
	private IHabitatRepo habitatRepo;

	/**
	 * Agrega un nuevo hábitat a la base de datos.
	 *
	 * @param habitat El hábitat que se va a agregar.
	 */
	@Override
	public void agregar(Habitat habitat) {
		this.habitatRepo.insertar(habitat);
	}

	/**
	 * Modifica los datos de un hábitat existente en la base de datos.
	 *
	 * @param habitat El hábitat con los datos actualizados.
	 */
	@Override
	public void modificar(Habitat habitat) {
		this.habitatRepo.actualizar(habitat);
	}

	/**
	 * Encuentra un hábitat por su tipo en la base de datos.
	 *
	 * @param tipo El tipo de hábitat a buscar.
	 * @return El hábitat encontrado, o null si no se encontró.
	 */
	@Override
	public Habitat encontrar(String tipo) {
		return this.habitatRepo.buscar(tipo);
	}

	/**
	 * Elimina un hábitat por su tipo en la base de datos.
	 *
	 * @param tipo El tipo de hábitat a eliminar.
	 */
	@Override
	public void borrar(String tipo) {
		this.habitatRepo.eliminar(tipo);
	}

	/**
	 * Obtiene una lista de todos los hábitats almacenados en la base de datos.
	 *
	 * @return Una lista de hábitats.
	 */
	@Override
	public List<Habitat> encontrarTodos() {
		return this.habitatRepo.encontrarTodos();
	}

	/**
	 * Busca un hábitat por su ID en la base de datos.
	 *
	 * @param id El ID del hábitat a buscar.
	 * @return El hábitat encontrado, o null si no se encontró.
	 */
	@Override
	public Habitat buscarPorId(Integer id) {
		return this.habitatRepo.buscarPorId(id);
	}

	/**
	 * Elimina un hábitat por su ID en la base de datos.
	 *
	 * @param id El ID del hábitat a eliminar.
	 */
	@Override
	public void eliminarPorId(Integer id) {
		this.habitatRepo.eliminarPorId(id);
	}
}

