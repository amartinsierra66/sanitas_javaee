package com.sanitas.service;

import java.util.List;

import com.sanitas.model.AlumnoDto;

public interface AlumnosService {
	boolean altaAlumno(AlumnoDto alumno);
	void eliminarAlumno(int idAlumno);
	List<AlumnoDto> alumnosCurso(String curso);
}
