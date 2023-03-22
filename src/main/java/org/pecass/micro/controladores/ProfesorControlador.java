package org.pecass.micro.controladores;

import java.util.List;

import org.pecass.micro.modelos.Profesor;
import org.pecass.micro.servicios.ProfesorServicio;
import org.pecass.micro.servicios.PersonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/colegio")
public class ProfesorControlador {
	
	@Autowired
	ProfesorServicio profesorServicio;
	@Autowired
	PersonaServicio personaServicio;
	
	@PostMapping("/profesor")
	public Profesor crearProfesor(@Validated @RequestBody Profesor profesor) {
		return profesorServicio.saveProfesor(profesor);
	}
	
	@GetMapping("/profesores")
	public List<Profesor> leerProfesors(){
		return profesorServicio.getAllProfesores();
	}
	
	@PutMapping("/profesor/{id}")
	public Profesor updateProfesor( @PathVariable String id, @Validated @RequestBody Profesor Profesor){
		return profesorServicio.saveProfesor(Profesor);	
	}
	
	@DeleteMapping("/profesor/{id}")
	public void deleteProfesor(@PathVariable String id) {
		personaServicio.deletePersona(id);
	}
	
	
}
