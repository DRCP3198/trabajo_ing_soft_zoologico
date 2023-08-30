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
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor_servicios")
public class ProveedorServicios {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_prove_serv")
	@SequenceGenerator(name = "seq_prove_serv", sequenceName = "seq_prove_serv", allocationSize = 1)
	@Column(name = "prov_serv_id")
	private Integer id;
	
	@Column(name = "prov_serv_nombre")
	private String nombre;

	@Column(name = "prov_serv_fecha_inicio_contrato")
	private LocalDate fechaInicioContrato;
	
	@Column(name = "prov_serv_fecha_fin_contrato")
	private LocalDate fechaFinContrato;

	@Column(name = "prov_serv_ruc")
	private String ruc;
	
	@Column(name = "prov_serv_codigo")
	private String codigo;
	
	// RELACIONES:
	
	@OneToMany(mappedBy = "proveedor_servicios")
	private List<AdquirirServicioProveedor> compras;
	
	@ManyToOne
	@JoinColumn(name="prov_id_zoologico")
	private Zoologico zoologico;

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<AdquirirServicioProveedor> getCompras() {
		return compras;
	}

	public void setCompras(List<AdquirirServicioProveedor> compras) {
		this.compras = compras;
	}

	public Zoologico getZoologico() {
		return zoologico;
	}

	public void setZoologico(Zoologico zoologico) {
		this.zoologico = zoologico;
	}
	
	
}
