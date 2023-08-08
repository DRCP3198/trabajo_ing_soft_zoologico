package com.example.demo.service;

import com.example.demo.modelo.Usuario;

public interface IUsuarioService {
	
	public void agregar(Usuario usuario);
	public Usuario encontrar(String usuario);

}
