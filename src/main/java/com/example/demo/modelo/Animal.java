package com.example.demo.modelo;

import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	//historial-animal
	@OneToOne(mappedBy = "animal")
	private HistorialClinico historial;
	
	//animal-habitad
	@ManyToOne
	@JoinColumn(name = "animal_id_habitad")
	private Habitat habitat;

	
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

	public HistorialClinico getHistorial() {
		return historial;
	}

	public void setHistorial(HistorialClinico historial) {
		this.historial = historial;
	}

	public Habitat getHabitat() {
		return habitat;
	}

	public void setHabitat(Habitat habitat) {
		this.habitat = habitat;
	}

	@Override
	public String toString() {
		return "Animal [id=" + id + ", nombreComun=" + nombreComun + ", especie=" + especie + ", nombreCientifico="
				+ nombreCientifico + ", genero=" + genero + ", peso=" + peso + ", edad=" + edad + "]";
	}




	
	
	
	
	

}
