package org.instituto.quito.metropolitano.implement;

import org.instituto.quito.metropolitano.entidad.Docente;
import org.instituto.quito.metropolitano.repositories.DocentesRepositori;
import org.instituto.quito.metropolitano.services.DocentesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocentesImplement implements DocentesServices {
    @Autowired
    private DocentesRepositori docentesRepositori;

    @Override
    public List<Docente> listarDocentes() {
        return docentesRepositori.findAll();
    }

    @Override
    public Docente guardarDocente(Docente docente) {
        return docentesRepositori.save(docente);
    }

    @Override
    public Docente obtenerDocente(Long id) {
        return docentesRepositori.findById(id).get();
    }

    @Override
    public Docente actualizarDocente(Docente docente) {
        return docentesRepositori.save(docente);
    }

    @Override
    public void eliminarDocente(Long id) {
        docentesRepositori.deleteById(id);
    }
}
