package org.instituto.quito.metropolitano.controlador;

import org.instituto.quito.metropolitano.entidad.Estudiante;
import org.instituto.quito.metropolitano.services.EstudiantesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstudianteControlador {

    @Autowired
    private EstudiantesServices estudiantesServices;

    @GetMapping("/estudiantes")
    public String listarEstudiantes(Model model){
        model.addAttribute("estudiantes",estudiantesServices.listarEstudiantes());
        return "estudiantes";
    }

    @GetMapping("/estudiantes/nuevo")
    public String crearEstudianteFormulario(Model model){
        Estudiante estudiante = new Estudiante();
        model.addAttribute("estudiante",estudiante);
        return "crear_estudiantes";
    }

    @PostMapping("/estudiantes")
    public String guardarEstudiante(@ModelAttribute("estudiante") Estudiante estudiante){
        estudiantesServices.guardarEstudiante(estudiante);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/editar/{id}")
    public String mostrarFomularioEditar(@PathVariable Long id, Model model){
        model.addAttribute("estudiante",estudiantesServices.obtenerEstudiante(id));
        return "editar_estudiante";
    }

    @PostMapping("/estudiantes/{id}")
    public String actualizarEstudiante(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model model){
        Estudiante estudianteExistente = estudiantesServices.obtenerEstudiante(id);
        estudianteExistente.setIdEstudiante(id);
        estudianteExistente.setNombre(estudiante.getNombre());
        estudianteExistente.setApellido(estudiante.getApellido());
        estudianteExistente.setEdad(estudiante.getEdad());

        estudiantesServices.actualizarEstudiante(estudianteExistente);
        return "redirect:/estudiantes";
    }

    @GetMapping("/estudiantes/{id}")
    public String eliminarEstudiante(@PathVariable Long id){
        estudiantesServices.eliminarEstudiante(id);
        return "redirect:/estudiantes";
    }
}
