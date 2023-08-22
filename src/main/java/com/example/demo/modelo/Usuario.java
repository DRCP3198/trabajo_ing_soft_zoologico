package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@Column(name="usu_usuario")
	private String usuarioNombre;
	
	@Column(name="usu_contraseña")
	private String contrasenia;
	
	@Column(name= "usu_rol_name")
	private String rolName;
	
	@ManyToOne
	@JoinColumn(name="usu_id_zoologico")
	private Zoologico zoologico;
	
	@OneToOne(mappedBy = "usuario")
	private Empleado empleado;
	
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

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getRolName() {
		return rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}
	
	


	
	
	
	

}
