package org.instituto.quito.metropolitano.entidad;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "estudiantes")
@RequiredArgsConstructor
@Getter
@Setter
public class Estudiante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;
    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;
    @Column(name = "edad",nullable = false)
    private int edad;

}