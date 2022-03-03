package com.sanitas.controller;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanitas.model.Alumno;
import com.sanitas.service.AlumnosService;

@Controller
public class AlumnosController {
	@Autowired
	AlumnosService alumnosService;
	@PostMapping("alta")
	public String altaAlumno(@RequestParam("nombre") String nombre, 
							@RequestParam("curso") String curso, 
							@RequestParam("nota") double nota, 
							HttpServletRequest request) {
		alumnosService.agregarAlumno(nombre, curso, nota);
		request.setAttribute("mensaje", "alumno agregado");
		return "inicio";
	}
	@GetMapping("media")
	public String media(HttpServletRequest request) {
		double media=alumnosService.media();
		request.setAttribute("media", media);
		return "media";
	}
	@GetMapping("alumnos")
	public String listadoAlumnos(@RequestParam("curso") String curso,HttpServletRequest request) {
		HashSet<Alumno> alumnos=alumnosService.alumnosCurso(curso);
		request.setAttribute("alumnos", alumnos);
		return "listado";
	}
}
