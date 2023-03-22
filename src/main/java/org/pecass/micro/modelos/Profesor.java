package org.pecass.micro.modelos;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity( name = "Profesor")
@Table(name="profesores", schema= "public")
@PrimaryKeyJoinColumn(name="id", foreignKey = @ForeignKey(name="fk:profeosor_persona"))
@OnDelete(action = OnDeleteAction.CASCADE)
public class Profesor extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="titulo" ,nullable = false)
	private String titulo;
	
	@Column(name="sueldo" ,nullable = false, columnDefinition = "integer DEFAULT '0'")
	private Integer sueldo= 0;
	
	@Column(name="estado" , nullable = false, columnDefinition = "integer DEFAULT '1'")
	private Integer estado= 1;
	
	@OneToMany(mappedBy = "profesor" , fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Curso> cursos;

	public String getTitulo() {
		return titulo;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getSueldo() {
		return sueldo;
	}

	public void setSueldo(Integer sueldo) {
		this.sueldo = sueldo;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
