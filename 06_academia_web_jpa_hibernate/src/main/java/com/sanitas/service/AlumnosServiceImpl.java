package com.sanitas.service;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.sanitas.model.Alumno;
@Service
public class AlumnosServiceImpl implements AlumnosService {
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public void agregarAlumno(Alumno alumno) {
		entityManager.persist(alumno);
		
	}

	@Override
	public void agregarAlumno(String nombre, String curso, double nota) {
		agregarAlumno(new Alumno(nombre, curso, nota));
		
	}

	@Override
	public double media() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int aprobados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double notaAlta() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean alumnoNotaMayor(double nota) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Alumno alumnoNotaMasAlta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno buscarAlumnoPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Alumno> alumnosCurso(String curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarAlumnoPorId(int idAlumno) {
		//localizamos la entidad
		Alumno alumno=entityManager.find(Alumno.class, idAlumno);
		if(alumno!=null) {
			entityManager.remove(alumno);
			return true;
		}
		return false;
		
	}
	
	
	
}
