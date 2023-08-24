package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produ")
	@SequenceGenerator(name = "seq_produ", sequenceName = "seq_produ", allocationSize = 1)
	@Column(name = "prod_id")
	private Integer id;

	@Column(name = "prod_nombre")
	private String nombre;

	@Column(name = "prod_tipo")
	private String tipo;

	@Column(name = "prod_cantidad_stock")
	private Integer cantidad_stock;

	@Column(name = "prod_codigo")
	private String codigo;

	@Column(name = "prod_descripcion")
	private String descripcion;

	@Column(name = "prod_precio")
	private BigDecimal precio;

	@Column(name = "prod_fecha_caducidad")
	private LocalDate fechaCaducidad;
	
	@Column(name = "prod_estado")
	private String estado;

	
	@OneToOne
	@JoinColumn(name="prod_id_almacen")
	private Almacen almacen;
	
	@ManyToOne
	@JoinColumn(name="prod_id_habit")
	private Habitat habitat;
	
	@OneToMany(mappedBy = "producto")
	private List<CompraProveedores> compras;
	

	// SET Y GET
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getCantidad_stock() {
		return cantidad_stock;
	}

	public void setCantidad_stock(Integer cantidad_stock) {
		this.cantidad_stock = cantidad_stock;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Almacen getAlmacen() {
		return almacen;
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}

	public Habitat getHabitat() {
		return habitat;
	}

	public void setHabitat(Habitat habitat) {
		this.habitat = habitat;
	}
	
	
	


	public List<CompraProveedores> getCompras() {
		return compras;
	}

	public void setCompras(List<CompraProveedores> compras) {
		this.compras = compras;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	


}