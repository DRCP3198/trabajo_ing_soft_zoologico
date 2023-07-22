package com.example.demo.modelo;

import java.math.BigDecimal;

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

@Entity
@Table(name = "empleado")
public class Empleado {
	
	@Id
	@SequenceGenerator(name = "seq_empl", sequenceName = "seq_empl", allocationSize = 1)
	@GeneratedValue(generator = "seq_empl", strategy = GenerationType.SEQUENCE)
	@Column(name = "empl_id")
	private Integer id;
	
	@Column(name = "empl_nombre")
	private String nombre;

	@Column(name = "empl_apellido")
	private String apellido;

	@Column(name = "empl_codigo")
	private String codigo;
	
	@Column(name = "empl_sueldo")
	private BigDecimal sueldo;

	@Column(name = "empl_cargo")
	private String cargo;
	
	@OneToOne(mappedBy = "empleado")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "empleado_id_zoologico")
	private Zoologico zoologico;

	//SET y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Zoologico getZoologico() {
		return zoologico;
	}

	public void setZoologico(Zoologico zoologico) {
		this.zoologico = zoologico;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", sueldo=" + sueldo
				+ ", cargo=" + cargo + "]";
	}
	
	
	

}
