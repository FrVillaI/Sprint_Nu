package org.instituto.quito.metropolitano.controlador;

import org.instituto.quito.metropolitano.entidad.Aula;
import org.instituto.quito.metropolitano.entidad.Horario;
import org.instituto.quito.metropolitano.services.AulaServices;
import org.instituto.quito.metropolitano.services.HorarioServices;
import org.instituto.quito.metropolitano.services.MateriaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HorarioControlador {
    @Autowired
    private HorarioServices horarioServices;
    @Autowired
    private MateriaServices materiaServices;
    @Autowired
    private AulaServices aulaServices;

    @GetMapping("/horarios")
    public String listarHorario(Model model){
        model.addAttribute("horarios",horarioServices.listarHorario());
        return "horarios";
    }

    @GetMapping("/horarios/nuevo")
    public String crearHorarioFormulario(Model model){
        model.addAttribute("materias",materiaServices.listarMateria());
        model.addAttribute("aulas",aulaServices.listarAulas());
        Horario horario = new Horario();
        model.addAttribute("horarios",horario);
        return "crear_horarios";
    }

    @PostMapping("/horarios")
    public String guardarHorario(@ModelAttribute("horarios") Horario horario){
        horarioServices.guardarHorario(horario);
        return "redirect:/horarios";
    }

    @GetMapping("/horarios/editar/{id}")
    public String mostrarFomularioEditar(@PathVariable Long id, Model model){
        model.addAttribute("materias",materiaServices.listarMateria());
        model.addAttribute("aulas",aulaServices.listarAulas());
        model.addAttribute("horario",horarioServices.obtenerHorario(id));
        return "editar_horarios";
    }

    @PostMapping("/horarios/{id}")
    public String actualizarDocente(@PathVariable Long id, @ModelAttribute("horario") Horario horario, Model model){
        Horario horarioExistente = horarioServices.obtenerHorario(id);
        horarioExistente.setIdHorario(id);
        horarioExistente.setHoraInicio(horario.getHoraInicio());
        horarioExistente.setHorarioFin(horario.getHorarioFin());
        horarioExistente.setMateria(horario.getMateria());
        horarioExistente.setAula(horario.getAula());

        horarioServices.actualizarHorario(horarioExistente);
        return "redirect:/horarios";
    }

    @GetMapping("/horarios/{id}")
    public String eliminarHorario(@PathVariable Long id){
        horarioServices.eliminarHorario(id);
        return "redirect:/horarios";
    }
}
