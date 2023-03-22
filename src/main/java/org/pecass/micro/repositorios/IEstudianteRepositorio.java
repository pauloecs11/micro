package org.pecass.micro.repositorios;

import org.pecass.micro.modelos.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteRepositorio  extends JpaRepository<Estudiante, String>{
	
}
