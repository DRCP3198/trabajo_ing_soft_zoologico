package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name="servicio_proveedores")
public class AdquirirServicioProveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_add_serv")
	@SequenceGenerator(name="seq_add_serv",sequenceName = "seq_add_serv", allocationSize = 1)
	@Column(name="add_serv_id")
	private Integer id;
	
	@Column(name="add_serv_fecha_adquisicion")
	private LocalDate fechaAdquisicion;
	
	@Column(name="add_serv_valor")
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name="serv_id_proveedor_servicios")
	private ProveedorServicios proveedorServicios;
	
	@ManyToOne
	@JoinColumn(name="serv_id_servicio")
	private Servicio servicio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public void setFechaAdquisicion(LocalDate fechaAdquisicion) {
		this.fechaAdquisicion = fechaAdquisicion;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public ProveedorServicios getProveedorServicios() {
		return proveedorServicios;
	}

	public void setProveedorServicios(ProveedorServicios proveedorServicios) {
		this.proveedorServicios = proveedorServicios;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	
	

}
