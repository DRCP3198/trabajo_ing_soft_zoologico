package com.example.demo.repository;

import com.example.demo.modelo.Usuario;

public interface IUsuarioRepo {
	
	public void insertar(Usuario usuario);
	public Usuario buscar(String usuario);
	

}
