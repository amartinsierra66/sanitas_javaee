package com.sanitas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanitas.converters.AlumnoConverter;
import com.sanitas.dao.AlumnosDao;
import com.sanitas.model.AlumnoDto;

@Service
public class AlumnosServiceImpl implements AlumnosService {	
	@Autowired
	AlumnosDao alumnosDao;
	@Autowired
	AlumnoConverter alumnoConverter;	
	@Override
	public boolean altaAlumno(AlumnoDto alumno) {
		if(alumnosDao.findByNombre(alumno.getNombre()).isEmpty()) {
			alumnosDao.save(alumnoConverter.dtoToAlumno(alumno));
			return true;
		}
		return false;
	}
	@Override
	public void eliminarAlumno(int idAlumno) {
		alumnosDao.deleteById(idAlumno);

	}
	@Override
	public List<AlumnoDto> alumnosCurso(String curso) {
		return alumnosDao.findByCurso(curso) //List<Alumno>
				.stream()
				.map(a->alumnoConverter.alumnoToDto(a)) //Stream<AlumnoDto>
				.collect(Collectors.toList());
	}

}
