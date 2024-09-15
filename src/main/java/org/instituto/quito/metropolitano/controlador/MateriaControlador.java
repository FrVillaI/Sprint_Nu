package org.instituto.quito.metropolitano.controlador;

import org.instituto.quito.metropolitano.entidad.Materia;
import org.instituto.quito.metropolitano.services.DocentesServices;
import org.instituto.quito.metropolitano.services.MateriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MateriaControlador {
    @Autowired
    private MateriaServices materiaServices;
    @Autowired
    private DocentesServices docentesServices;

    @GetMapping("/materias")
    public String listarMateria(Model model){
        model.addAttribute("materias",materiaServices.listarMateria());
        return "materias";
    }

    @GetMapping("/materias/nuevo")
    public String crearAulasFormulario(Model model){
        model.addAttribute("docentes", docentesServices.listarDocentes());
        Materia materia = new Materia();
        model.addAttribute("materias", materia);
        return "crear_materias";
    }


    @PostMapping("/materias")
    public String guardarMateria(@ModelAttribute("materias") Materia materia){
        materiaServices.guardarMateria(materia);
        return "redirect:/materias";
    }

    @GetMapping("/materias/editar/{id}")
    public String mostrarFomularioEditar(@PathVariable Long id, Model model){
        model.addAttribute("materias",materiaServices.obtenerMateria(id));
        return "editar_materias";
    }

    @PostMapping("/materias/{id}")
    public String actualizarDocente(@PathVariable Long id, @ModelAttribute("materias") Materia materia, Model model){
        Materia materiaExistente = materiaServices.obtenerMateria(id);
        materiaExistente.setIdMateria(id);
        materiaExistente.setNombre(materia.getNombre());
        materiaExistente.setDescripcion(materia.getDescripcion());
        materiaExistente.setDocente(materia.getDocente());

        materiaServices.actualizarMateria(materiaExistente);
        return "redirect:/materias";
    }

    @GetMapping("/materias/{id}")
    public String eliminarMateria(@PathVariable Long id){
        materiaServices.eliminarMateria(id);
        return "redirect:/materias";
    }
}
