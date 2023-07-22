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
@Table(name="producto")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_producto")
	@SequenceGenerator(name = "seq_producto",sequenceName = "seq_producto", allocationSize = 1)
	@Column(name="prod_id")
	private Integer id;
	
	@Column(name="prod_nombre")
	private String nombre;
	
	@Column(name="prod_stock")
	private Integer stock;
	
	@Column(name="prod_precio")
	private BigDecimal precio;
	
	@Column(name="prod_fecha_caducidad")
	private LocalDate fechaCaducidad;
	
	@ManyToOne
	@JoinColumn(name="prod_id_prov")
	private Proveedor proveedor;

	//SET Y GET
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

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public LocalDate getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(LocalDate fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", stock=" + stock + ", precio=" + precio
				+ ", fechaCaducidad=" + fechaCaducidad + "]";
	}
	
	

}
