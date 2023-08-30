package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Zoologico;
import com.example.demo.repository.IZoologicoRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ZoologicoServiceImpl implements IZoologicoService {

	@Autowired
	private IZoologicoRepo iZoologicoRepo;

	@Override
	public void agregar(Zoologico zoologico) {
		// TODO Auto-generated method stub
		this.iZoologicoRepo.insertar(zoologico);
	}

}
