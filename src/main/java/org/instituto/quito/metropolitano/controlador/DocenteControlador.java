package org.instituto.quito.metropolitano.controlador;

import org.instituto.quito.metropolitano.entidad.Docente;
import org.instituto.quito.metropolitano.services.DocentesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DocenteControlador {
    @Autowired
    private DocentesServices docentesServices;

    @GetMapping("/docentes")
    public String listarDocentes(Model model){
        model.addAttribute("docentes",docentesServices.listarDocentes());
        return "docentes";
    }

    @GetMapping("/docentes/nuevo")
    public String crearDocenteFormulario(Model model){
        Docente docente = new Docente();
        model.addAttribute("docentes",docente);
        return "crear_docentes";
    }

    @PostMapping("/docentes")
    public String guardarDocente(@ModelAttribute("docente") Docente docente){
        docentesServices.guardarDocente(docente);
        return "redirect:/docentes";
    }

    @GetMapping("/docentes/editar/{id}")
    public String mostrarFomularioEditar(@PathVariable Long id, Model model){
        model.addAttribute("docente",docentesServices.obtenerDocente(id));
        return "editar_docentes";
    }

    @PostMapping("/docentes/{id}")
    public String actualizarDocente(@PathVariable Long id, @ModelAttribute("docente") Docente docente, Model model){
        Docente docenteExistente = docentesServices.obtenerDocente(id);
        docenteExistente.setIdDocente(id);
        docenteExistente.setNombre(docente.getNombre());
        docenteExistente.setApellido(docente.getApellido());
        docenteExistente.setEdad(docente.getEdad());

        docentesServices.actualizarDocente(docenteExistente);
        return "redirect:/docentes";
    }

    @GetMapping("/docentes/{id}")
    public String eliminarDocente(@PathVariable Long id){
        docentesServices.eliminarDocente(id);
        return "redirect:/docentes";
    }
}
