package com.example.demo.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Table(name= "habitat")
@Entity
public class Habitat {
	
	@Id
	@SequenceGenerator(name = "seq_habitat", sequenceName = "seq_habitat", allocationSize = 1)
	@GeneratedValue(generator = "seq_habitat", strategy = GenerationType.SEQUENCE)
	@Column(name = "hab_id")
	private Integer id;
	
	@Column(name = "hab_tipo")
	private String tipo;
	
	@Column(name = "hab_tamaño")
	private String tamanio;
	
	@Column(name = "hab_descripción")
	private String descripcion;
	
	@Column(name = "hab_clima")
	private String clima;
	
	
	@OneToMany(mappedBy = "habitat")
	private List<Animal> animales; 
	
	@OneToMany(mappedBy = "habitat")
	private List<Producto> productos;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}



	public List<Animal> getAnimales() {
		return animales;
	}

	public void setAnimales(List<Animal> animales) {
		this.animales = animales;
	}

	
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	

}
