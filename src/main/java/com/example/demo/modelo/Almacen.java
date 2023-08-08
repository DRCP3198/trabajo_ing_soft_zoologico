package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "almacen")
public class Almacen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_almacen")
	@SequenceGenerator(name = "seq_almacen", sequenceName = "seq_almacen", allocationSize = 1)
	@Column(name = "alm_id")
	private Integer id;
	
	@Column(name = "alm_capacidad")
	private Integer capacidad;
	
	
	@Column(name = "alm_nombre")
	private String nombre;
	
	@Column(name = "alm_tipo")
	private String tipo;
	
	@OneToOne(mappedBy = "almacen")
	private Producto producto;
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	
	

	
	

}
