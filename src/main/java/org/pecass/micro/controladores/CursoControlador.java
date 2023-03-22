package org.pecass.micro.controladores;

import java.util.List;

import org.pecass.micro.modelos.Curso;
import org.pecass.micro.servicios.CursoServicio;
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
public class CursoControlador {
	
	@Autowired
	private CursoServicio cursoServicio;
	
	@PostMapping("/curso")
	public Curso crearCurso(Curso curso){
		return cursoServicio.saveCurso(curso);
	}
	
	@GetMapping("/cursos")
	public List<Curso> leerCursos(){
		return cursoServicio.getAllCursos();
	}
	
	@PutMapping("/curso/{id}")
	public Curso updateCurso(@PathVariable Long id,@Validated @RequestBody Curso curso ) {
		return cursoServicio.saveCurso(curso);
	}

	@DeleteMapping("/curso/{id}")
	public void deleteCurso(@PathVariable Long id) {
		cursoServicio.deleteCurso(id);
	}
	
}
