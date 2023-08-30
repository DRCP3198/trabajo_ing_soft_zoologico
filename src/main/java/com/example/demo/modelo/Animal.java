package com.example.demo.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * Esta clase representa un animal en el sistema.
 */
@Entity
@Table(name = "animal")
public class Animal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_animal")
	@SequenceGenerator(name = "seq_animal", sequenceName = "seq_animal", allocationSize = 1)
	@Column(name = "anim_id")
	private Integer id;
	
	@Column(name = "anim_nombre_comun")
	private String nombreComun;
	
	@Column(name = "anim_especie")
	private String especie;
	
	@Column(name = "anim_nombre_cientifico")
	private String nombreCientifico;
	
	@Column(name = "anim_genero")
	private String genero;
	
	@Column(name = "anim_peso")
	private Integer peso;
	
	@Column(name = "anim_edad")
	private Integer edad;
	
	// RELACIONES:
	
	@ManyToOne
	@JoinColumn(name = "anim_id_habitat")
	private Habitat habitat;
	
	@OneToMany(mappedBy = "animal")
	List<citaHistorialClinico> citas;

	/**
	 * Obtiene el ID del animal.
	 *
	 * @return El ID del animal.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Establece el ID del animal.
	 *
	 * @param id El nuevo ID del animal.
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	// Métodos Getter y Setter para los otros campos...

	/**
	 * Obtiene el hábitat al que pertenece el animal.
	 *
	 * @return El hábitat del animal.
	 */
	public Habitat getHabitat() {
		return habitat;
	}

	/**
	 * Establece el hábitat al que pertenece el animal.
	 *
	 * @param habitat El nuevo hábitat del animal.
	 */
	public void setHabitat(Habitat habitat) {
		this.habitat = habitat;
	}

	/**
	 * Obtiene la lista de citas y registros de historial clínico del animal.
	 *
	 * @return La lista de citas y registros de historial clínico.
	 */
	public List<citaHistorialClinico> getCitas() {
		return citas;
	}

	/**
	 * Establece la lista de citas y registros de historial clínico del animal.
	 *
	 * @param citas La nueva lista de citas y registros de historial clínico.
	 */
	public void setCitas(List<citaHistorialClinico> citas) {
		this.citas = citas;
	}

	// Resto de los comentarios...
}

