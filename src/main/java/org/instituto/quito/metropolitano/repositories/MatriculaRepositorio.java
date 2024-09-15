package org.instituto.quito.metropolitano.repositories;

import org.instituto.quito.metropolitano.entidad.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepositorio extends JpaRepository<Matricula, Long> {
}
