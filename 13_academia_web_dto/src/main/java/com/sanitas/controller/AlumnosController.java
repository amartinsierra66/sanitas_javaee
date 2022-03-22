package com.sanitas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sanitas.model.AlumnoDto;
import com.sanitas.service.AlumnosService;
@CrossOrigin("*")
@Controller
public class AlumnosController {
	@Autowired
	AlumnosService alumnosService;
	@PostMapping("alta")
	public String altaAlumno(@ModelAttribute("alumno") AlumnoDto alumno, 
			HttpServletRequest request) {		
		if(alumnosService.altaAlumno(alumno)) {
			request.setAttribute("mensaje", "Alumno agregado");
		}else {
			request.setAttribute("mensaje", "El alumno no se pudo añadir");
		}
		return "inicio";
	}
	/*public String altaAlumno(@RequestParam("nombre") String nombre, 
							@RequestParam("curso") String curso, 
							@RequestParam("nota") double nota, 
							HttpServletRequest request) {
		Alumno alumno=new Alumno(nombre, curso, nota);
		if(alumnosService.altaAlumno(alumno)) {
			request.setAttribute("mensaje", "Alumno agregado");
		}else {
			request.setAttribute("mensaje", "El alumno no se pudo añadir");
		}
		return "inicio";
	}*/
	
	
	@GetMapping(value="alumnos",produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<AlumnoDto> listadoAlumnos(@RequestParam("curso") String curso) {
		return alumnosService.alumnosCurso(curso);
	}
}
