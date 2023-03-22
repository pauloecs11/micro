package org.pecass.micro.modelos;

import java.io.Serializable;
import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name="Estudiante")
@Table(name="estudiantes", schema = "public")
@PrimaryKeyJoinColumn(name="id", foreignKey = @ForeignKey(name="fk_estudiante_persona"))
@OnDelete(action = OnDeleteAction.CASCADE)
public class Estudiante extends Persona implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	//@JoinTable( name="CursoEstudiante")
	//private List<Curso> cursos_enrolados;
	@ManyToMany( cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable( name="estudiantes_cursos",
			joinColumns = @JoinColumn(
					name="id_estudiante",
					referencedColumnName = "id",
					foreignKey = @ForeignKey(name ="fk_estudiante_curso",
					foreignKeyDefinition = 
						"FOREIGN KEY ( id_estudiante )\r\n"
						+ " REFERENCES public.estudiantes (id) MATCH SIMPLE \r\n"
						+ " ON UPDATE CASCADE \r\n"
						+ " ON DELETE CASCADE ",
						value = ConstraintMode.CONSTRAINT
							)
					),
			inverseJoinColumns = @JoinColumn(
					name="codigo_curso",
					referencedColumnName = "codigo",
					foreignKey = @ForeignKey(name ="fk_curso_estudiante",
					foreignKeyDefinition = 
					
						"FOREIGN KEY ( codigo_curso )\r\n"
						+ " REFERENCES public.cursos (codigo) MATCH SIMPLE \r\n"
						+ " ON UPDATE CASCADE \r\n"
						+ " ON DELETE CASCADE ",
						value = ConstraintMode.CONSTRAINT
							)
					),
			uniqueConstraints = @UniqueConstraint(name="clave_compuesta",columnNames = {"id_estudiante","codigo_curso"})
	)
	private List<Curso> cursos_enrolados;
	
	
	@Column(name="beca" , columnDefinition = "boolean DEFAULT 'false'")
	private boolean beca= false;
	
	@Column(name="estado" , columnDefinition = "integer DEFAULT '1'")
	private Integer estado= 1;

	public boolean isBeca() {
		return beca;
	}

	public void setBeca(boolean beca) {
		this.beca = beca;
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
