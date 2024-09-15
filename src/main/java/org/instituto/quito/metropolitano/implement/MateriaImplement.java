package org.instituto.quito.metropolitano.implement;

import org.instituto.quito.metropolitano.entidad.Materia;
import org.instituto.quito.metropolitano.repositories.MateriaRepositorio;
import org.instituto.quito.metropolitano.services.MateriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaImplement implements MateriaServices {
    @Autowired
    private MateriaRepositorio materiaRepositorio;

    @Override
    public List<Materia> listarMateria() {
        return materiaRepositorio.findAll();
    }

    @Override
    public Materia guardarMateria(Materia materia) {
        return materiaRepositorio.save(materia);
    }

    @Override
    public Materia obtenerMateria(Long id) {
        return materiaRepositorio.findById(id).get();
    }

    @Override
    public Materia actualizarMateria(Materia materia) {
        return materiaRepositorio.save(materia);
    }

    @Override
    public void eliminarMateria(Long id) {
        materiaRepositorio.deleteById(id);
    }
}
