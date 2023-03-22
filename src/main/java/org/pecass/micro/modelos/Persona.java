package org.pecass.micro.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity(name="Persona")
@Table(name="personas", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {
	
	@Id
	@Column(name="id", length = 10)
	private String id;
	
	@Column(name="nombre", nullable = false)
	private String nombre;
	
	@Column(name="sexo",nullable = false,length = 1)
	private String sexo;
	
	@Column(name="email",nullable = false)
	private String email;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
