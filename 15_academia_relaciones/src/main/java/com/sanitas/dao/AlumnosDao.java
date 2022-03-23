package com.sanitas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sanitas.entities.Alumno;

public interface AlumnosDao extends JpaRepository<Alumno,String>{
	@Query("select a from Alumno a where a.curso.denominacion=?1")
	//lista de alumnos por nombre de curso
	List<Alumno> findAlumnosByCurso(String curso);
	@Query("select a from Alumno a where a.curso.duracion<=?1")
	//lista de alumnos matriculados en cursos cuya duración es inferior al parámetro
	List<Alumno> findAlumnosByDuraction(int duracion);
}
