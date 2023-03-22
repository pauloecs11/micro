package org.pecass.micro.servicios;

import java.util.List;

import org.pecass.micro.modelos.Profesor;
import org.pecass.micro.repositorios.IProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfesorServicio {

	@Autowired
	private IProfesorRepositorio iProfesorRepositorio;
	
	public Profesor saveProfesor(Profesor profesor) {
		return iProfesorRepositorio.save(profesor);
	}
	
	public List<Profesor> getAllProfesores(){
		return iProfesorRepositorio.findAll();
	}
}
