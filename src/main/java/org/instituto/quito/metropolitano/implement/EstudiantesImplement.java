package org.instituto.quito.metropolitano.implement;

import org.instituto.quito.metropolitano.entidad.Estudiante;
import org.instituto.quito.metropolitano.repositories.EstudianteRepositori;
import org.instituto.quito.metropolitano.services.EstudiantesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudiantesImplement implements EstudiantesServices {

    @Autowired
    private EstudianteRepositori estudianteRepositori;

    @Override
    public List<Estudiante> listarEstudiantes() {
        return estudianteRepositori.findAll();
    }

    @Override
    public Estudiante guardarEstudiante(Estudiante estudiante) {
        return estudianteRepositori.save(estudiante);
    }

    @Override
    public Estudiante obtenerEstudiante(Long id) {
        return estudianteRepositori.findById(id).get();
    }

    @Override
    public Estudiante actualizarEstudiante(Estudiante estudiante) {
        return estudianteRepositori.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Long id) {
        estudianteRepositori.deleteById(id);
    }

}
