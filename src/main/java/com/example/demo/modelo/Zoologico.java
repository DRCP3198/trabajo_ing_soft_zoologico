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

@Table(name = "zoologico")
@Entity
public class Zoologico {

	@Id
	@SequenceGenerator(name = "seq_zoo", sequenceName = "seq_zoo", allocationSize = 1)
	@GeneratedValue(generator = "seq_zoo", strategy = GenerationType.SEQUENCE)
	@Column(name = "zoo_id")
	private Integer id;

	@Column(name = "zoo_id")
	private String nombre;

	@Column(name = "zoo_direccion")
	private String direccion;

	@Column(name = "zoo_numero_telefono")
	private String numeroTlf;

	@Column(name = "zoo_tamaño")
	private String tamanio;

	//relacion con proveedor
	@OneToMany(mappedBy = "zoologico")
	private List<Proveedor> provedores;
	
	//relacion con cliente
	@OneToMany(mappedBy = "zoologico")
	private List<Cliente> clientes;
	
	

}
