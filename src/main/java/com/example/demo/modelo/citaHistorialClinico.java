package com.example.demo.modelo;

import java.time.LocalDateTime;

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
@Table(name="cita_historial_clinico")
public class citaHistorialClinico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cita_historial")
	@SequenceGenerator(name = "seq_cita_historial",sequenceName = "seq_cita_historial", allocationSize = 1)
	@Column(name="citaHist_id")
	private Integer id;
	
	@Column(name="citaHist_fecha_cita")
	private LocalDateTime fechaCita;
	
	@Column(name="citaHist_observaciones")
	private String observaciones;
	
	@Column(name="citaHist_diagnostico")
	private String diagnostico;
	
	@ManyToOne
	@JoinColumn(name = "cta_id_clinico")
	private HistorialClinico historial_clinico;
	
	@ManyToOne
	@JoinColumn(name = "cta_id_animal")
	private Animal animal;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public HistorialClinico getHistorial_clinico() {
		return historial_clinico;
	}

	public void setHistorial_clinico(HistorialClinico historial_clinico) {
		this.historial_clinico = historial_clinico;
	}

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	
}
