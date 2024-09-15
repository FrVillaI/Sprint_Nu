package org.instituto.quito.metropolitano.entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Data
public class Matricula implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMatricula;
    private LocalDate fechaMatricula;
    @ManyToOne
    @JoinColumn(name = "idMateria", referencedColumnName = "idMateria")
    private Materia materia;
    @ManyToOne
    @JoinColumn(name = "idEstudiante",referencedColumnName = "idEstudiante")
    private Estudiante estudiante;
}
