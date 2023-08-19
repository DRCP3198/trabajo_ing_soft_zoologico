package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Almacen;
import com.example.demo.repository.IAlmacenRepo;

@Service
public class AlmacenServiceImpl implements IAlmacenService{
	
	@Autowired
	private IAlmacenRepo almacenRepo;

	@Override
	public void agregar(Almacen almacen) {
		// TODO Auto-generated method stub
		this.almacenRepo.insertar(almacen);
	}

	@Override
	public void modificar(Almacen almacen) {
		// TODO Auto-generated method stub
		this.almacenRepo.actualizar(almacen);
	}

	@Override
	public Almacen encontrar(String nombre) {
		// TODO Auto-generated method stub
		return this.almacenRepo.buscar(nombre);
	}

	@Override
	public void borrar(String nombre) {
		// TODO Auto-generated method stub
		this.almacenRepo.eliminar(nombre);
	}

	@Override
	public List<Almacen> encontrarTodos() {
		return almacenRepo.encontrarTodos();
	}

}