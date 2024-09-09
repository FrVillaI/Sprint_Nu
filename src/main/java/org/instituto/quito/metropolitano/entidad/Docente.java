package org.instituto.quito.metropolitano.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "docentes")
@RequiredArgsConstructor
@Getter
@Setter
public class Docente implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDocente;
    private String nombre;
    private String apellido;
    private int edad;
}
