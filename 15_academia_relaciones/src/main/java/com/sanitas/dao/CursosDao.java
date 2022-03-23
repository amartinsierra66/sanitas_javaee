package com.sanitas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sanitas.entities.Curso;

public interface CursosDao extends JpaRepository<Curso,Integer>{
	@Query("select c from Curso c join c.alumnos a where a.dni=?1")
	//obtener el curso en el que está matriculado un determinado alumno
	Curso findCursoByAlumno(String dni);
}
