package com.example.demo.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="especie")
public class Especie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_especie")
	@SequenceGenerator(name = "seq_especie",sequenceName = "seq_especie", allocationSize = 1)
	@Column(name="espe_id")
	private Integer id;
	
	@Column(name="espe_nombre_comun")
	private String nombreComun;
	
	@Column(name="espe_nombre_cientifico")
	private String nombreCientifico;
	
	@Column(name="espe_id")
	private Integer edadPromedio;
	
	@Column(name="espe_id")
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="espe_id_animal")
	private List<Animal> animales;

}
