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
@Table(name="compraProveedores")
public class CompraProveedores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_compra")
	@SequenceGenerator(name="seq_compra",sequenceName = "seq_compra", allocationSize = 1)
	@Column(name="comp_id")
	private Integer id;
	
	@Column(name="comp_fechaCompra")
	private LocalDate fechaCompra;
	
	@Column(name="comp_cantidad")
	private Integer cantidad;
	
	@Column(name="comp_valor")
	private BigDecimal valorCompra;
	
	@ManyToOne
	@JoinColumn(name="comp_id_proveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name="comp_id_producto")
	private Producto producto;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}
	
	
	

}
