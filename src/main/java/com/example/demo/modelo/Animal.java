package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
	@Column(name="anim_tipo")
	private String tipo;
	
	@Column(name="anim_edad")
	private Integer edad;
	
	
	@OneToMany
	private Especie especie;

}
