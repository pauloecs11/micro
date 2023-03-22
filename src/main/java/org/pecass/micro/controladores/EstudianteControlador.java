package org.pecass.micro.controladores;

import java.util.List;

import org.pecass.micro.modelos.Estudiante;
import org.pecass.micro.servicios.EstudianteServicio;
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
public class EstudianteControlador {
	
	@Autowired
	EstudianteServicio estudianteServicio;
	@Autowired
	PersonaServicio personaServicio;
	
	@PostMapping("/estudiante")
	public Estudiante crearEstudiante(@Validated @RequestBody Estudiante estudiante) {
		return estudianteServicio.saveEstudiante(estudiante);
	}
	
	@GetMapping("/estudiantes")
	public List<Estudiante> leerEstudiantes(){
		return estudianteServicio.getAllEstudiantes();
	}
	
	@PutMapping("/estudiante/{id}")
	public Estudiante updateEstudiante( @PathVariable String id, @Validated @RequestBody Estudiante estudiante){
		return estudianteServicio.saveEstudiante(estudiante);
		
	}
	
	@DeleteMapping("/estudiante/{id}")
	public void deleteEstudiante(@PathVariable String id) {
		personaServicio.deletePersona(id);
	}
	
}
