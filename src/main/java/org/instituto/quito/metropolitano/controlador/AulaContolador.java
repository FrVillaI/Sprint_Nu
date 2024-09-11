package org.instituto.quito.metropolitano.controlador;

import org.instituto.quito.metropolitano.entidad.Aula;
import org.instituto.quito.metropolitano.services.AulaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AulaContolador {
    @Autowired
    private AulaServices aulaServices;
    @GetMapping("/aulas")
    public String listarAulas(Model model){
        model.addAttribute("aulas",aulaServices.listarAulas());
        return "aulas";
    }

    @GetMapping("/aulas/nuevo")
    public String crearAulasFormulario(Model model){
        Aula aula = new Aula();
        model.addAttribute("aulas",aula);
        return "crear_aulas";
    }

    @PostMapping("/aulas")
    public String guardarAula(@ModelAttribute("aulas") Aula aula){
        aulaServices.guardarAula(aula);
        return "redirect:/aulas";
    }

    @GetMapping("/aulas/editar/{id}")
    public String mostrarFomularioEditar(@PathVariable Long id, Model model){
        model.addAttribute("aula",aulaServices.obtenerAula(id));
        return "editar_aulas";
    }

    @PostMapping("/aulas/{id}")
    public String actualizarDocente(@PathVariable Long id, @ModelAttribute("aulas") Aula aula, Model model){
        Aula aulaExistente = aulaServices.obtenerAula(id);
        aulaExistente.setIdAula(id);
        aulaExistente.setNumeroAula(aula.getNumeroAula());
        aulaExistente.setCapacidadEstudiantes(aula.getCapacidadEstudiantes());

        aulaServices.actualizarAula(aulaExistente);
        return "redirect:/aulas";
    }

    @GetMapping("/aulas/{id}")
    public String eliminarDocente(@PathVariable Long id){
        aulaServices.eliminarAula(id);
        return "redirect:/aulas";
    }
}
