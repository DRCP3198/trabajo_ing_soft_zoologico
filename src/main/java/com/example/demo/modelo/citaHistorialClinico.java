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

/**
 * Esta clase representa una cita en el historial clínico de un animal.
 */
@Entity
@Table(name = "cita_historial_clinico")
public class citaHistorialClinico {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cita_historial")
	@SequenceGenerator(name = "seq_cita_historial", sequenceName = "seq_cita_historial", allocationSize = 1)
	@Column(name = "citaHist_id")
	private Integer id;
	
	@Column(name = "citaHist_fecha_cita")
	private LocalDateTime fechaCita;
	
	@Column(name = "citaHist_observaciones")
	private String observaciones;
	
	@Column(name = "citaHist_diagnostico")
	private String diagnostico;
	
	@ManyToOne
	@JoinColumn(name = "cta_id_clinico")
	private HistorialClinico historial_clinico;
	
	@ManyToOne
	@JoinColumn(name = "cta_id_animal")
	private Animal animal;

	/**
	 * Obtiene el ID de la cita en el historial clínico.
	 *
	 * @return El ID de la cita.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Establece el ID de la cita en el historial clínico.
	 *
	 * @param id El nuevo ID de la cita.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	// Métodos Getter y Setter para los otros campos...

	/**
	 * Obtiene la fecha y hora de la cita en el historial clínico.
	 *
	 * @return La fecha y hora de la cita.
	 */
	public LocalDateTime getFechaCita() {
		return fechaCita;
	}

	/**
	 * Establece la fecha y hora de la cita en el historial clínico.
	 *
	 * @param fechaCita La nueva fecha y hora de la cita.
	 */
	public void setFechaCita(LocalDateTime fechaCita) {
		this.fechaCita = fechaCita;
	}

	/**
	 * Obtiene las observaciones registradas en la cita.
	 *
	 * @return Las observaciones de la cita.
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * Establece las observaciones de la cita.
	 *
	 * @param observaciones Las nuevas observaciones de la cita.
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * Obtiene el diagnóstico registrado en la cita.
	 *
	 * @return El diagnóstico de la cita.
	 */
	public String getDiagnostico() {
		return diagnostico;
	}

	/**
	 * Establece el diagnóstico de la cita.
	 *
	 * @param diagnostico El nuevo diagnóstico de la cita.
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	/**
	 * Obtiene el historial clínico al que está asociada la cita.
	 *
	 * @return El historial clínico asociado a la cita.
	 */
	public HistorialClinico getHistorial_clinico() {
		return historial_clinico;
	}

	/**
	 * Establece el historial clínico asociado a la cita.
	 *
	 * @param historial_clinico El nuevo historial clínico asociado a la cita.
	 */
	public void setHistorial_clinico(HistorialClinico historial_clinico) {
		this.historial_clinico = historial_clinico;
	}

	/**
	 * Obtiene el animal al que está relacionada la cita.
	 *
	 * @return El animal asociado a la cita.
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * Establece el animal asociado a la cita.
	 *
	 * @param animal El nuevo animal asociado a la cita.
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	// Resto de los comentarios...
}

