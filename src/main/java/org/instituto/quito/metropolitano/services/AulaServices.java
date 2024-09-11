package org.instituto.quito.metropolitano.services;

import org.instituto.quito.metropolitano.entidad.Aula;

import java.util.List;

public interface AulaServices {
    public List<Aula> listarAulas();

    public Aula guardarAula(Aula aula);

    public Aula obtenerAula(Long id);

    public Aula actualizarAula(Aula aula);

    public void eliminarAula(Long id);
}
