package com.sanitas.service;

import java.util.List;

import com.sanitas.entities.Matricula;

public interface MatriculacionesService {
	List<Matricula> matriculacionesCurso(int idCurso);
}
