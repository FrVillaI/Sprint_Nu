package org.instituto.quito.metropolitano.implement;

import org.instituto.quito.metropolitano.entidad.Aula;
import org.instituto.quito.metropolitano.repositories.AulaRepositori;
import org.instituto.quito.metropolitano.services.AulaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaImplment implements AulaServices {
    @Autowired
    private AulaRepositori aulaRepositori;

    @Override
    public List<Aula> listarAulas() {
        return aulaRepositori.findAll();
    }

    @Override
    public Aula guardarAula(Aula aula) {
        return aulaRepositori.save(aula);
    }

    @Override
    public Aula obtenerAula(Long id) {
        return aulaRepositori.findById(id).get();
    }

    @Override
    public Aula actualizarAula(Aula aula) {
        return aulaRepositori.save(aula);
    }

    @Override
    public void eliminarAula(Long id) {
        aulaRepositori.deleteById(id);
    }
}
