package org.instituto.quito.metropolitano.services;

import org.instituto.quito.metropolitano.entidad.Estudiante;

import java.util.List;

public interface EstudiantesServices{
    public List<Estudiante> listarEstudiantes();

    public Estudiante guardarEstudiante(Estudiante estudiante);

    public Estudiante obtenerEstudiante(Long id);

    public Estudiante actualizarEstudiante(Estudiante estudiante);

    public void eliminarEstudiante(Long id);

}
