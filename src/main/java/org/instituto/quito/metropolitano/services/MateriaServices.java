package org.instituto.quito.metropolitano.services;

import org.instituto.quito.metropolitano.entidad.Materia;

import java.util.List;

public interface MateriaServices {
    public List<Materia> listarMateria();

    public Materia guardarMateria(Materia materia);

    public Materia obtenerMateria(Long id);

    public Materia actualizarMateria(Materia materia);

    public void eliminarMateria(Long id);
}
