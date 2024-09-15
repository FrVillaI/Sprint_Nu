package org.instituto.quito.metropolitano.services;

import org.instituto.quito.metropolitano.entidad.Horario;

import java.util.List;

public interface HorarioServices {
    public List<Horario> listarHorario();

    public Horario guardarHorario(Horario horario);

    public Horario obtenerHorario(Long id);

    public Horario actualizarHorario(Horario horario);

    public void eliminarHorario(Long id);
}
