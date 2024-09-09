package org.instituto.quito.metropolitano.entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Data
public class Horario implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idHorario;
    private Time horaInicio;
    private Time horarioFin;
    @ManyToOne
    @JoinColumn(name = "idMateria",referencedColumnName = "idMateria")
    private Materia materia;
    @ManyToOne
    @JoinColumn(name = "idAula",referencedColumnName = "idAula")
    private Aula aula;
}
