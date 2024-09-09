package org.instituto.quito.metropolitano.repositories;

import org.instituto.quito.metropolitano.entidad.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositori extends JpaRepository<Estudiante,Long> {
}
