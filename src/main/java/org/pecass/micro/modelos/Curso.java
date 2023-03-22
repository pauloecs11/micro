package org.pecass.micro.modelos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name="Curso")
@Table(name="cursos")
public class Curso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(
			name="id_profesor",
			referencedColumnName = "id",
			foreignKey = @ForeignKey(name ="fk_curso_profesor", foreignKeyDefinition = 
			
				"FOREIGN KEY ( id_profesor )\r\n"
				+ " REFERENCES public.profesores (id) MATCH SIMPLE \r\n"
				+ " ON UPDATE CASCADE \r\n"
				+ " ON DELETE CASCADE ",
				value = ConstraintMode.CONSTRAINT
					)
			)
	private Profesor profesor;
	
	
	@Column(name="nombre", nullable = false, unique = true)
	private String nombre;
	
	@Column(name = "fecha_inicio", nullable = false, columnDefinition = "date DEFAULT 'now()'")
	private LocalDate fecha_inicio=ZonedDateTime.now(ZoneId.of("America/Santiago")).toLocalDate();
	
	@Column(name="fecha_fin", nullable = false)
	private LocalDate fecha_fin;

	@ManyToMany(mappedBy = "cursos_enrolados",fetch =FetchType.LAZY,cascade=CascadeType.MERGE)
	private List<Estudiante> estudiantes_enrolados;
	
	
	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Estudiante> getEstudiantes_enrolados() {
		return estudiantes_enrolados;
	}

	public void setEstudiantes_enrolados(List<Estudiante> estudiantes_enrolados) {
		this.estudiantes_enrolados = estudiantes_enrolados;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(LocalDate fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public LocalDate getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(LocalDate fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
