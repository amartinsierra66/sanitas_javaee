package com.sanitas.service;

import java.util.HashSet;

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

	Alumno buscarAlumnoPorNombre(String nombre);

	HashSet<Alumno> alumnosCurso(String curso);

}