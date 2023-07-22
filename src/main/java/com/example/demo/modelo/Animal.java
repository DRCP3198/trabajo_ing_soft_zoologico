package com.example.demo.modelo;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="animal")
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_animal")
	@SequenceGenerator(name = "seq_animal",sequenceName = "seq_animal", allocationSize = 1)
	@Column(name="anim_id")
	private Integer id;
	
	@Column(name="anim_nombre_comun")
	private String nombreComun;
	
	@Column(name="anim_especie")
	private String especie;
	
	@Column(name="anim_nombre_cientifico")
	private String nombreCientifico;
	
	@Column(name="anim_genero")
	private String genero;
	
	@Column(name="anim_peso")
	private Integer peso;
	
	@Column(name="anim_edad")
	private Integer edad;
	
	// RELACIONES:
	
	//historial
	@ManyToMany(mappedBy = "animales")
	private List<HistorialClinico>historiales;
	
	//animal
	@ManyToMany(mappedBy = "animales")
	private List<Producto>productos;

	
	//Set and Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreComun() {
		return nombreComun;
	}

	public void setNombreComun(String nombreComun) {
		this.nombreComun = nombreComun;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getNombreCientifico() {
		return nombreCientifico;
	}

	public void setNombreCientifico(String nombreCientifico) {
		this.nombreCientifico = nombreCientifico;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public List<HistorialClinico> getHistoriales() {
		return historiales;
	}

	public void setHistoriales(List<HistorialClinico> historiales) {
		this.historiales = historiales;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}


	
	
	
	
	

}
