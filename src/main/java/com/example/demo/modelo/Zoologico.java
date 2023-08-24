package com.example.demo.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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

	@Column(name = "zoo_nombre")
	private String nombre;

	@Column(name = "zoo_direccion")
	private String direccion;

	@Column(name = "zoo_numero_telefono")
	private String numeroTlf;

	@Column(name = "zoo_tamaño")
	private String tamanio;
	
	@OneToMany(mappedBy = "zoologico")
	private List<Proveedor> proveedores;
	



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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNumeroTlf() {
		return numeroTlf;
	}

	public void setNumeroTlf(String numeroTlf) {
		this.numeroTlf = numeroTlf;
	}

	public String getTamanio() {
		return tamanio;
	}

	public void setTamanio(String tamanio) {
		this.tamanio = tamanio;
	}



	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}


	
	

}
