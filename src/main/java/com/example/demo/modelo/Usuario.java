package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name="usuario")
@Entity
public class Usuario {
	
	@Id
	@SequenceGenerator(sequenceName = "seq_usuario",name = "seq_usuario",allocationSize = 1)
	@GeneratedValue(generator = "seq_usuario",strategy =  GenerationType.SEQUENCE)
	@Column(name="usu_id")
	private Integer id;
	
	@Column(name="usu_usuario_nombre")
	private String usuarioNombre;
	
	@Column(name="usu_contraseña")
	private String contrasenia;
	
	//Relación zoologico-usuario
	@OneToOne(mappedBy = "usuario")
	private Zoologico zoologico;
	
	//Relación cliente-usuario
	@OneToOne(mappedBy = "usuario")
	private Cliente cliente;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuarioNombre() {
		return usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public Zoologico getZoologico() {
		return zoologico;
	}

	public void setZoologico(Zoologico zoologico) {
		this.zoologico = zoologico;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuarioNombre=" + usuarioNombre + ", contrasenia=" + contrasenia + "]";
	}
	
	
	
	
	

}
