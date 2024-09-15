package org.instituto.quito.metropolitano.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
public class Materia implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMateria;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idDocente")
    private Docente docente;
}
