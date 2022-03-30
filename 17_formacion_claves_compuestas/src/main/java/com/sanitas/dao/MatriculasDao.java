package com.sanitas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sanitas.entities.Matricula;
import com.sanitas.entities.MatriculaPk;

public interface MatriculasDao extends JpaRepository<Matricula, MatriculaPk> {
	@Query("select m from Matricula m where m.matriculaPk.idCurso=?1")
	List<Matricula> findMatriculaByCurso(int idCurso);
}
