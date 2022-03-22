package com.sanitas.converters;

import org.springframework.stereotype.Component;

import com.sanitas.entities.Alumno;
import com.sanitas.model.AlumnoDto;
@Component
public class AlumnoConverterImpl implements AlumnoConverter {

	@Override
	public AlumnoDto alumnoToDto(Alumno alumno) {
		return new AlumnoDto(alumno.getNombre(),alumno.getCurso(),alumno.getNota());
	}

	@Override
	public Alumno dtoToAlumno(AlumnoDto dto) {
		return new Alumno(dto.getNombre(),dto.getCurso(),dto.getCalificacion());
	}

}
