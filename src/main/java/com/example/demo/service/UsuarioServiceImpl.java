package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Usuario;
import com.example.demo.repository.IUsuarioRepo;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	
	@Autowired
	private IUsuarioRepo iUsuarioRepo;

	@Override
	public void agregar(Usuario usuario) {
		// TODO Auto-generated method stub
		this.iUsuarioRepo.insertar(usuario);
	}

	@Override
	public Usuario encontrar(String usuario) {
		// TODO Auto-generated method stub
		return this.iUsuarioRepo.buscar(usuario);
	}

}
