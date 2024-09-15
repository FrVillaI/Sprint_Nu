package org.instituto.quito.metropolitano.implement;

import org.instituto.quito.metropolitano.entidad.Horario;
import org.instituto.quito.metropolitano.repositories.HorarioRepositorio;
import org.instituto.quito.metropolitano.services.HorarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioImplement implements HorarioServices {
    @Autowired
    private HorarioRepositorio horarioRepositorio;

    @Override
    public List<Horario> listarHorario() {
        return horarioRepositorio.findAll();
    }

    @Override
    public Horario guardarHorario(Horario horario) {
        return horarioRepositorio.save(horario);
    }

    @Override
    public Horario obtenerHorario(Long id) {
        return horarioRepositorio.findById(id).get();
    }

    @Override
    public Horario actualizarHorario(Horario horario) {
        return horarioRepositorio.save(horario);
    }

    @Override
    public void eliminarHorario(Long id) {
        horarioRepositorio.deleteById(id);
    }
}
