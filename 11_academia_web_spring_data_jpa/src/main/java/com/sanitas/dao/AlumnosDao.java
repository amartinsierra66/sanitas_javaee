package com.sanitas.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

import com.sanitas.model.Alumno;

public interface AlumnosDao extends JpaRepository<Alumno,Integer>{
	
	//si no encuentra el alumno, devuelve null
	//pero si hay m?s de un resultado, se produce una IncorrectResultSizeDataAccessException.
	//Alumno findByNombre(String nombre);
	
	Optional<Alumno> findByNombre(String nombre);
	List<Alumno> findByCurso(String curso);
	@Transactional
	@Modifying
	void deleteByCurso(String curso);
}
