package org.instituto.quito.metropolitano.services;

import org.instituto.quito.metropolitano.entidad.Docente;

import java.util.List;

public interface DocentesServices {
    public List<Docente> listarDocentes();

    public Docente guardarDocente(Docente docente);

    public Docente obtenerDocente(Long id);

    public Docente actualizarDocente(Docente docente);

    public void eliminarDocente(Long id);
}
