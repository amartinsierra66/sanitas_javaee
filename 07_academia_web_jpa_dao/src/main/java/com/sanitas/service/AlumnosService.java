package com.sanitas.service;

import java.util.Optional;
import java.util.Set;

import com.sanitas.model.Alumno;

public interface AlumnosService {

	//recoge alumno y lo guarda
	void agregarAlumno(Alumno alumno);

	void agregarAlumno(String nombre, String curso, double nota);

	//devuelve la nota media global
	double media();

	int aprobados();

	double notaAlta();

	boolean alumnoNotaMayor(double nota);

	Alumno alumnoNotaMasAlta();

	Optional<Alumno> buscarAlumnoPorNombre(String nombre);

	Set<Alumno> alumnosCurso(String curso);
	
	boolean eliminarAlumnoPorId(int idAlumno);
	
	void eliminarAlumnosCurso(String curso);

}