package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Esta clase representa un almacén para productos.
 */
@Entity
@Table(name = "almacen")
public class Almacen {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_almacen")
	@SequenceGenerator(name = "seq_almacen", sequenceName = "seq_almacen", allocationSize = 1)
	@Column(name = "alm_id")
	private Integer id;
	
	@Column(name = "alm_capacidad")
	private Integer capacidad;
	
	@Column(name = "alm_nombre")
	private String nombre;
	
	@Column(name = "alm_tipo")
	private String tipo;
	
	@OneToOne(mappedBy = "almacen")
	private Producto producto;

	/**
	 * Obtiene el ID del almacén.
	 *
	 * @return El ID del almacén.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Establece el ID del almacén.
	 *
	 * @param id El nuevo ID del almacén.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Obtiene la capacidad del almacén.
	 *
	 * @return La capacidad del almacén.
	 */
	public Integer getCapacidad() {
		return capacidad;
	}

	/**
	 * Establece la capacidad del almacén.
	 *
	 * @param capacidad La nueva capacidad del almacén.
	 */
	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	/**
	 * Obtiene el nombre del almacén.
	 *
	 * @return El nombre del almacén.
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece el nombre del almacén.
	 *
	 * @param nombre El nuevo nombre del almacén.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene el tipo de almacén.
	 *
	 * @return El tipo de almacén.
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Establece el tipo de almacén.
	 *
	 * @param tipo El nuevo tipo de almacén.
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene el producto asociado al almacén.
	 *
	 * @return El producto asociado al almacén.
	 */
	public Producto getProducto() {
		return producto;
	}

	/**
	 * Establece el producto asociado al almacén.
	 *
	 * @param producto El nuevo producto asociado al almacén.
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}


	
	

	
	


