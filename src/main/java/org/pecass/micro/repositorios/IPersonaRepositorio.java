package org.pecass.micro.repositorios;

import org.pecass.micro.modelos.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonaRepositorio extends JpaRepository<Persona, String>{

	
}
