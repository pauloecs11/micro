package org.pecass.micro.servicios;

import java.util.List;

import org.pecass.micro.modelos.Estudiante;
import org.pecass.micro.repositorios.IEstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServicio {

	@Autowired
	private IEstudianteRepositorio iEstudianteRepositorio;

	public Estudiante saveEstudiante(Estudiante estudiante) {
		return iEstudianteRepositorio.save(estudiante);
	}
	
	public List<Estudiante> getAllEstudiantes(){
		return iEstudianteRepositorio.findAll();
	}
	
	
}
