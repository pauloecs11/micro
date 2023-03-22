package org.pecass.micro.servicios;

import java.util.List;

import org.pecass.micro.modelos.Curso;
import org.pecass.micro.repositorios.ICursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServicio {

	@Autowired 
	private ICursoRepositorio iCursoRepositorio;
	
	public Curso saveCurso(Curso curso) {
		return iCursoRepositorio.save(curso);
	}
	
	public List<Curso> getAllCursos(){
		return iCursoRepositorio.findAll();
	}
	
	public void deleteCurso(Long codigo) {
		iCursoRepositorio.deleteById(codigo);
	}
	
}
