package com.example.demo.modelo;

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
 * Esta clase representa el historial de citas en el sistema.
 */
@Table(name = "histarialcitas")
@Entity
public class HistorialCitas {

	@Id
	@SequenceGenerator(name = "seq_histo_citas", sequenceName = "seq_histo_citas", allocationSize = 1)
	@GeneratedValue(generator = "seq_histo_citas", strategy = GenerationType.SEQUENCE)
	@Column(name = "hcit_id")
	private Integer id;

	@Column(name = "hcit_fecha_ingreso")
	private LocalDate fechaIngreso;

	@Column(name = "hcit_fecha_salida")
	private LocalDate fechaSalida;

	@ManyToOne
	@JoinColumn(name = "hcit_id_historial")
	private HistorialClinico historialClinico;

	// Métodos Getter y Setter:

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	/**
	 * Obtiene el historial clínico asociado al historial de citas.
	 *
	 * @return El historial clínico asociado al historial de citas.
	 */
	public HistorialClinico getHistorialClinico() {
		return historialClinico;
	}

	/**
	 * Establece el historial clínico asociado al historial de citas.
	 *
	 * @param historialClinico El nuevo historial clínico asociado al historial de citas.
	 */
	public void setHistorialClinico(HistorialClinico historialClinico) {
		this.historialClinico = historialClinico;
	}
}

