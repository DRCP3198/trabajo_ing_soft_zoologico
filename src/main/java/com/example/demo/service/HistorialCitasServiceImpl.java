package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.HistorialCitas;
import com.example.demo.repository.IHistorialCitasRepo;

@Service
public class HistorialCitasServiceImpl implements IHistorialCitasService{
	
	@Autowired
	private IHistorialCitasRepo citasRepo;

	@Override
	public void agregar(HistorialCitas citas) {
		// TODO Auto-generated method stub
		this.citasRepo.insertar(citas);
	}

	@Override
	public List<HistorialCitas> encontrar(LocalDateTime fechaIngreso) {
		// TODO Auto-generated method stub
		return this.citasRepo.buscar(fechaIngreso);
	}

	@Override
	public HistorialCitas buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.citasRepo.buscarId(id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.citasRepo.eliminar(id);
	}
	
	public void borrarCita(LocalDateTime fechaIngreso) {
		List<HistorialCitas> cita = this.encontrar(fechaIngreso);
		
		for(HistorialCitas var: cita) {
			HistorialCitas buscar = this.buscarId(var.getId());
			this.citasRepo.eliminar(buscar.getId());
		}
	}

	@Override
	public void actualizar(HistorialCitas citas) {
		// TODO Auto-generated method stub
		this.citasRepo.actualizar(citas);
	}

	@Override
	public List<HistorialCitas> buscarTodos() {
		// TODO Auto-generated method stub
		return this.citasRepo.buscarTodos();
	}

}
