package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")
public class Servicio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_servicio")
	@SequenceGenerator(name = "seq_servicio", sequenceName = "seq_servicio", allocationSize = 1)
	@Column(name = "serv_id")
	private Integer id;
	
	@Column(name = "serv_nombre")
	private String nombre;
	
	@Column(name = "serv_codigo")
	private String codigo;
	
	@Column(name = "serv_fecha_inicio")
	private LocalDate fechaInicio;
	
	@Column(name = "serv_fecha_fin")
	private LocalDate fechaFin;
	
	@Column(name = "serv_valor_dia")
	private BigDecimal valorPorDia;
	
	@Column(name = "serv_estado")
	private String estado;
	
	
	@OneToMany(mappedBy = "servicio")
	private List<AdquirirServicioProveedor> compras;

	@ManyToOne
	@JoinColumn(name="serv_id_habit")
	private Habitat habitat;
	
	

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

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public BigDecimal getValorPorDia() {
		return valorPorDia;
	}

	public void setValorPorDia(BigDecimal valorPorDia) {
		this.valorPorDia = valorPorDia;
	}

	public List<AdquirirServicioProveedor> getCompras() {
		return compras;
	}

	public void setCompras(List<AdquirirServicioProveedor> compras) {
		this.compras = compras;
	}

	public Habitat getHabitat() {
		return habitat;
	}

	public void setHabitat(Habitat habitat) {
		this.habitat = habitat;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
}
