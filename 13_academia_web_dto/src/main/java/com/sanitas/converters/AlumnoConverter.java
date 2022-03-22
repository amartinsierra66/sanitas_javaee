package com.sanitas.converters;

import com.sanitas.entities.Alumno;
import com.sanitas.model.AlumnoDto;

public interface AlumnoConverter {
	AlumnoDto alumnoToDto(Alumno alumno);
	Alumno dtoToAlumno(AlumnoDto dto);
}
