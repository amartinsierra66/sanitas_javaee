package com.sanitas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanitas.dao.AlumnosDao;
import com.sanitas.model.Alumno;

@Service
public class AlumnosServiceImpl implements AlumnosService {	
	@Autowired
	AlumnosDao alumnosDao;
	@Override
	public boolean altaAlumno(Alumno alumno) {
		if(alumnosDao.findByNombre(alumno.getNombre())==null) {
			alumnosDao.save(alumno);
			return true;
		}
		return false;
	}

	@Override
	public void eliminarAlumno(int idAlumno) {
		Alumno al=alumnosDao.findById(idAlumno);
		if(al!=null) {
			alumnosDao.remove(al);
		}

	}

	@Override
	public List<Alumno> alumnosCurso(String curso) {
		return alumnosDao.findByCurso(curso);
	}

}
