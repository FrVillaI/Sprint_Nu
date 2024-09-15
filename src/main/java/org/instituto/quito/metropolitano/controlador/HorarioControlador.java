package org.instituto.quito.metropolitano.controlador;

import org.instituto.quito.metropolitano.entidad.Horario;
import org.instituto.quito.metropolitano.services.HorarioServices;
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

    @GetMapping("/horarios")
    public String listarHorario(Model model){
        model.addAttribute("horarios",horarioServices.listarHorario());
        return "horarios";
    }

    @GetMapping("/horarios/nuevo")
    public String crearHorarioFormulario(Model model){
        Horario horario = new Horario();
        model.addAttribute("horarios",horario);
        return "crear_horarios";
    }

    @PostMapping("/horarios")
    public String guardarMateria(@ModelAttribute("horarios") Horario horario){
        horarioServices.guardarHorario(horario);
        return "redirect:/horarios";
    }

    @GetMapping("/horarios/editar/{id}")
    public String mostrarFomularioEditar(@PathVariable Long id, Model model){
        model.addAttribute("horarios",horarioServices.obtenerHorario(id));
        return "editar_horarios";
    }

    @PostMapping("/horarios/{id}")
    public String actualizarDocente(@PathVariable Long id, @ModelAttribute("horarios") Horario horario, Model model){
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
