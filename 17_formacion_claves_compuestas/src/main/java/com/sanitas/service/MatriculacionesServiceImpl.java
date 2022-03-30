package com.sanitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanitas.dao.MatriculasDao;
import com.sanitas.entities.Matricula;
@Service
public class MatriculacionesServiceImpl implements MatriculacionesService {
	@Autowired
	MatriculasDao matriculasDao;
	@Override
	public List<Matricula> matriculacionesCurso(int idCurso) {
		return matriculasDao.findMatriculaByCurso(idCurso);
	}

}
