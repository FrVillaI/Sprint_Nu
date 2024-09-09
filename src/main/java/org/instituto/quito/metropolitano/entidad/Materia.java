package org.instituto.quito.metropolitano.entidad;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Data
public class Materia implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idMateria;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idDocente",referencedColumnName = "idDocente")
    private Docente docente;
}
