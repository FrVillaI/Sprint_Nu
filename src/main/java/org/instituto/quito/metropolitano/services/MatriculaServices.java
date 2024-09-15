package org.instituto.quito.metropolitano.services;


import org.instituto.quito.metropolitano.entidad.Matricula;

import java.util.List;

public interface MatriculaServices {
    public List<Matricula> listarMatricula();

    public Matricula guardarMatricula(Matricula matricula);

    public Matricula obtenerMatricula(Long id);

    public Matricula actualizarMatricula(Matricula matricula);

    public void eliminarMatricula(Long id);
}
