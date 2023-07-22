package com.example.demo.modelo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_prove")
	@SequenceGenerator(name = "seq_prove", sequenceName = "seq_prove", allocationSize = 1)
	@Column(name = "prov_id")
	private Integer id;

	@Column(name = "prov_nombre")
	private String nombre;

	@Column(name = "prov_fecha_contrato")
	private LocalDate fechaContrato;

	@Column(name = "prov_ruc")
	private String ruc;
	
	@Column(name = "prov_codigo")
	private String codigo;
	
	// RELACIONES:
	// servicio:
	@OneToOne(mappedBy = "proveedor")
	private Servicio servicio;

	// productos:
	@OneToMany(mappedBy = "proveedor")
	private List<Producto> productos;

	// zoológico:
	@ManyToOne
	@JoinColumn(name = "prove_id_zoo")
	private Zoologico zoologico;
	


	// toString:
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", fechaContrato=" + fechaContrato + ", ruc=" + ruc
				+ ", codigo=" + codigo + "]";
	}

	// GET Y SET
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

	public LocalDate getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(LocalDate fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public Zoologico getZoologico() {
		return zoologico;
	}

	public void setZoologico(Zoologico zoologico) {
		this.zoologico = zoologico;
	}

	
	public String getCodigo() {
		return codigo;
	}

	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
}
