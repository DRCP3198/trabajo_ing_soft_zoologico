package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_servi")
	@SequenceGenerator(name = "seq_servi", sequenceName = "seq_servi", allocationSize = 1)
	@Column(name = "serv_id")
	private Integer id;

	@Column(name = "serv_tipo")
	private String tipo;

	@Column(name = "serv_fecha_inicio")
	private LocalDate fechaInicioContrato;

	@Column(name = "serv_fecha_fin")
	private LocalDate fechaFinContrato;

	@Column(name = "serv_precio")
	private BigDecimal precio;
	
	@Column(name = "serv_codigo")
	private String codigo;

	// RELACIONES:
	@OneToOne
	@JoinColumn(name = "serv_id_proveedor")
	private Proveedor proveedor;

	// toString:
	@Override
	public String toString() {
		return "Servicio [id=" + id + ", tipo=" + tipo + ", fechaInicioContrato=" + fechaInicioContrato
				+ ", fechaFinContrato=" + fechaFinContrato + ", precio=" + precio + ", codigo=" + codigo + "]";
	}

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
}
