package com.sanitas.dao;

import java.util.List;

import com.sanitas.model.Alumno;

public interface AlumnosDao {
	void save(Alumno al);
	void remove(Alumno al);
	Alumno findById(int idAlumno);
	Alumno findByNombre(String nombre);
	List<Alumno> findByCurso(String curso);
	void deleteByCurso(String curso);
}
