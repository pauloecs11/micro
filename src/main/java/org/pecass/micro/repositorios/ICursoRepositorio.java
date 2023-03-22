package org.pecass.micro.repositorios;

import org.pecass.micro.modelos.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepositorio extends JpaRepository<Curso, Long>{

}
