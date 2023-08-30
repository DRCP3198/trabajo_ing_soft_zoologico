package com.example.demo.modelo;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

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

	@Column(name = "prov_fecha_inicio_contrato")
	private LocalDate fechaInicioContrato;
	
	@Column(name = "prov_fecha_fin_contrato")
	private LocalDate fechaFinContrato;

	@Column(name = "prov_ruc")
	private String ruc;
	
	@Column(name = "prov_codigo")
	private String codigo;
	
	// RELACIONES:
	
	@OneToMany(mappedBy = "proveedor")
	private List<CompraProveedores> compras;
	
	@ManyToOne
	@JoinColumn(name="prov_id_zoologico")
	private Zoologico zoologico;
	


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

	public LocalDate getFechaInicioContrato() {
		return fechaInicioContrato;
	}

	public void setFechaInicioContrato(LocalDate fechaInicioContrato) {
		this.fechaInicioContrato = fechaInicioContrato;
	}

	public LocalDate getFechaFinContrato() {
		return fechaFinContrato;
	}

	public void setFechaFinContrato(LocalDate fechaFinContrato) {
		this.fechaFinContrato = fechaFinContrato;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	
	
	
	
	public List<CompraProveedores> getCompras() {
		return compras;
	}

	public void setCompras(List<CompraProveedores> compras) {
		this.compras = compras;
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

