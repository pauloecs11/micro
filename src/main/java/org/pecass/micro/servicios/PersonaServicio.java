package org.pecass.micro.servicios;

import org.pecass.micro.repositorios.IPersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServicio {

	@Autowired
	private IPersonaRepositorio iPersonaRepositorio;
	
	public void deletePersona(String id) {
		iPersonaRepositorio.deleteById(id);
	}
}
