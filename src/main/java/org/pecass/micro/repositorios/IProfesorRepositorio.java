package org.pecass.micro.repositorios;

import org.pecass.micro.modelos.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProfesorRepositorio extends JpaRepository<Profesor, String>{
	

}
