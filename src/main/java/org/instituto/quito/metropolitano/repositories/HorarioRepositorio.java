package org.instituto.quito.metropolitano.repositories;

import org.instituto.quito.metropolitano.entidad.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepositorio extends JpaRepository<Horario,Long> {
}
