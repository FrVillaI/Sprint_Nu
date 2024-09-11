package org.instituto.quito.metropolitano.repositories;

import org.instituto.quito.metropolitano.entidad.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepositori extends JpaRepository<Aula, Long> {
}
