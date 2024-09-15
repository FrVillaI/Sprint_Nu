package org.instituto.quito.metropolitano.repositories;

import org.instituto.quito.metropolitano.entidad.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepositorio extends JpaRepository<Materia,Long> {
}
