package org.instituto.quito.metropolitano.repositories;

import org.instituto.quito.metropolitano.entidad.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocentesRepositori extends JpaRepository<Docente,Long> {
}
