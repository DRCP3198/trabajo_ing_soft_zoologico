package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.citaHistorialClinico;
import com.example.demo.repository.IcitaHistorialClinicoRepository;

@Service
public class citaHistorialClinicoServiceImpl implements IcitaHistorialClinicoService{

	@Autowired
	private IcitaHistorialClinicoRepository clinicoRepository;
	
	
	@Override
	public void insertar(citaHistorialClinico citaHistorialClinico) {
		// TODO Auto-generated method stub
		citaHistorialClinico.setFechaCita(LocalDateTime.now());
		this.clinicoRepository.insertar(citaHistorialClinico);
	}

	@Override
	public void actualizar(citaHistorialClinico citaHistorialClinico) {
		// TODO Auto-generated method stub
		this.clinicoRepository.actualizar(citaHistorialClinico);
	}

	@Override
	public List<citaHistorialClinico> buscarTodos() {
		// TODO Auto-generated method stub
		return this.clinicoRepository.buscarTodos();
	}

}
