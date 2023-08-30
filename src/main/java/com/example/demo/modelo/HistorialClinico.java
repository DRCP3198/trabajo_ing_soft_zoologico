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
	
	@Column(name="hclin_descripcion")
	private String descripcion;	
	
	@OneToMany(mappedBy = "historial_clinico")
	List<citaHistorialClinico> citas;

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<citaHistorialClinico> getCitas() {
		return citas;
	}

	public void setCitas(List<citaHistorialClinico> citas) {
		this.citas = citas;
	}

	
	

	

	


	
	
}
