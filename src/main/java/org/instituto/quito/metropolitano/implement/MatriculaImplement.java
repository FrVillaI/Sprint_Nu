package org.instituto.quito.metropolitano.implement;

import org.instituto.quito.metropolitano.entidad.Matricula;
import org.instituto.quito.metropolitano.repositories.MatriculaRepositorio;
import org.instituto.quito.metropolitano.services.MatriculaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaImplement implements MatriculaServices {
    @Autowired
    private MatriculaRepositorio matriculaRepositorio;

    @Override
    public List<Matricula> listarMatricula() {
        return matriculaRepositorio.findAll();
    }

    @Override
    public Matricula guardarMatricula(Matricula matricula) {
        return matriculaRepositorio.save(matricula);
    }

    @Override
    public Matricula obtenerMatricula(Long id) {
        return matriculaRepositorio.findById(id).get();
    }

    @Override
    public Matricula actualizarMatricula(Matricula matricula) {
        return matriculaRepositorio.save(matricula);
    }

    @Override
    public void eliminarMatricula(Long id) {
        matriculaRepositorio.deleteById(id);
    }
}
