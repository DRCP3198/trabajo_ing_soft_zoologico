package com.example.demo.modelo;

import java.time.LocalDateTime;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="historial_clinico")
public class HistorialClinico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_historial")
	@SequenceGenerator(name = "seq_historial",sequenceName = "seq_historial", allocationSize = 1)
	@Column(name="hclin_id")
	private Integer id;
	
	@Column(name="hclin_fecha_registro")
	private LocalDateTime fechaRegistro;
	
	@Column(name="hclin_fecha_alta")
	private LocalDateTime fechaAlta;
	
	@Column(name="hclin_diagnostico")
	private String diagnostico;
	
	@Column(name="hclin_observaciones")
	private String observaciones;
	
	// RELACIONES:
	@OneToOne(mappedBy = "historial")
	private Animal animal;
	
	@OneToMany(mappedBy="clinico")
	private List<HistorialCitas> historialCitas;
	

	//Set and Get
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public List<HistorialCitas> getHistorialCitas() {
		return historialCitas;
	}

	public void setHistorialCitas(List<HistorialCitas> historialCitas) {
		this.historialCitas = historialCitas;
	}

	@Override
	public String toString() {
		return "HistorialClinico [id=" + id + ", fechaRegistro=" + fechaRegistro + ", fechaAlta=" + fechaAlta
				+ ", diagnostico=" + diagnostico + ", observaciones=" + observaciones + "]";
	}

	


	
	
}
