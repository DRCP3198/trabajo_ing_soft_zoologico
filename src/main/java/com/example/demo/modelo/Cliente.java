package com.example.demo.modelo;

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
@Table(name= "cliente")
public class Cliente {
	@Id
	@SequenceGenerator(name = "seq_clie", sequenceName = "seq_clie", allocationSize = 1)
	@GeneratedValue(generator = "seq_clie", strategy = GenerationType.SEQUENCE)
	@Column(name = "clie_id")
	private Integer id;	
	
	@Column(name = "clie_nombre")
	private String nombre;

	@Column(name = "clie_apellido")
	private String apellido;

	@Column(name = "clie_edad")
	private Integer edad;

	@Column(name = "clie_correo")
	private String correo;

	@Column(name = "clie_cédula")
	private String cedula;

	@Column(name = "clie_dirección")
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name="cliente_id_zoologico")
	private Zoologico zoologico;
	
	
	

}
