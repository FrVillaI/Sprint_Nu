package org.instituto.quito.metropolitano.controlador;

import org.instituto.quito.metropolitano.entidad.Estudiante;
import org.instituto.quito.metropolitano.entidad.Matricula;
import org.instituto.quito.metropolitano.services.EstudiantesServices;
import org.instituto.quito.metropolitano.services.MateriaServices;
import org.instituto.quito.metropolitano.services.MatriculaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MatriculaControlador {
    @Autowired
    private MatriculaServices matriculaServices;
    @Autowired
    private EstudiantesServices estudiantesServices;
    @Autowired
    private MateriaServices materiaServices;

    @GetMapping("/matriculas")
    public String listarMatricula(Model model){
        model.addAttribute("matriculas",matriculaServices.listarMatricula());
        return "matriculas";
    }

    @GetMapping("/matriculas/nuevo")
    public String crearMatriculaFormulario(Model model){
        model.addAttribute("materias",materiaServices.listarMateria());
        model.addAttribute("estudiantes",estudiantesServices.listarEstudiantes());
        Matricula matricula = new Matricula();
        model.addAttribute("matriculas",matricula);
        return "crear_matriculas";
    }

    @PostMapping("/matriculas")
    public String guardarMatricula(@ModelAttribute("matriculas") Matricula matricula){
        matriculaServices.guardarMatricula(matricula);
        return "redirect:/matriculas";
    }

    @GetMapping("/matriculas/editar/{id}")
    public String mostrarFomularioEditar(@PathVariable Long id, Model model){
        model.addAttribute("materias",materiaServices.listarMateria());
        model.addAttribute("estudiantes",estudiantesServices.listarEstudiantes());
        model.addAttribute("matricula",matriculaServices.obtenerMatricula(id));
        return "editar_matriculas";
    }

    @PostMapping("/matriculas/{id}")
    public String actualizarMatricula(@PathVariable Long id, @ModelAttribute("matricula") Matricula matricula, Model model){
        Matricula matriculaExistente = matriculaServices.obtenerMatricula(id);
        matriculaExistente.setIdMatricula(id);
        matriculaExistente.setFechaMatricula(matricula.getFechaMatricula());
        matriculaExistente.setEstudiante(matricula.getEstudiante());
        matriculaExistente.setMateria(matricula.getMateria());

        matriculaServices.actualizarMatricula(matriculaExistente);
        return "redirect:/matriculas";
    }

    @GetMapping("/matriculas/{id}")
    public String eliminarMatricula(@PathVariable Long id){
        matriculaServices.eliminarMatricula(id);
        return "redirect:/matriculas";
    }
}
