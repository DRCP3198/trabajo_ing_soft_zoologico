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

/**
 * Esta clase representa una compra realizada a proveedores en el sistema.
 */
@Entity
@Table(name = "compraProveedores")
public class CompraProveedores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_compra")
	@SequenceGenerator(name = "seq_compra", sequenceName = "seq_compra", allocationSize = 1)
	@Column(name = "comp_id")
	private Integer id;
	
	@Column(name = "comp_fechaCompra")
	private LocalDate fechaCompra;
	
	@Column(name = "comp_cantidad")
	private Integer cantidad;
	
	@Column(name = "comp_valor")
	private BigDecimal valorCompra;
	
	@ManyToOne
	@JoinColumn(name = "comp_id_proveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "comp_id_producto")
	private Producto producto;
	
	// Métodos Getter y Setter:

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

	/**
	 * Obtiene el proveedor asociado a la compra.
	 *
	 * @return El proveedor asociado a la compra.
	 */
	public Proveedor getProveedor() {
		return proveedor;
	}

	/**
	 * Establece el proveedor asociado a la compra.
	 *
	 * @param proveedor El nuevo proveedor asociado a la compra.
	 */
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	/**
	 * Obtiene el producto asociado a la compra.
	 *
	 * @return El producto asociado a la compra.
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * Establece el producto asociado a la compra.
	 *
	 * @param producto El nuevo producto asociado a la compra.
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}
