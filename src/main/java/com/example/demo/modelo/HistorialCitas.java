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



	public HistorialClinico getHistorialClinico() {
		return historialClinico;
	}

	public void setHistorialClinico(HistorialClinico historialClinico) {
		this.historialClinico = historialClinico;
	}


	
	
}
