package org.pecass.micro.modelos;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity(name="Estudiante")
@Table(name="estudiantes", schema = "public")
@PrimaryKeyJoinColumn(name="id", foreignKey = @ForeignKey(name="fk_estudiante_persona"))
public class Estudiante extends Persona implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Column(name="beca" , columnDefinition = "boolean DEFAULT 'false'")
	private boolean beca= false;
	
	@Column(name="estado" , columnDefinition = "integer DEFAULT '1'")
	private Integer estado= 1;
	
}
