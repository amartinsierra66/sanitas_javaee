package com.sanitas.service;

import java.util.List;

import com.sanitas.model.Alumno;

public interface AlumnosService {
	boolean altaAlumno(Alumno alumno);
	void eliminarAlumno(int idAlumno);
	List<Alumno> alumnosCurso(String curso);
}
