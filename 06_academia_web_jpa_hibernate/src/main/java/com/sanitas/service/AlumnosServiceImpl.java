package com.sanitas.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sanitas.model.Alumno;
@Service
public class AlumnosServiceImpl implements AlumnosService {
	@PersistenceContext()
	EntityManager entityManager;
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void agregarAlumno(Alumno alumno) {
		entityManager.persist(alumno);	
	}
	@Transactional(propagation = Propagation.REQUIRED)
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
	public Optional<Alumno> buscarAlumnoPorNombre(String nombre) {
		String jpql="select a from Alumno a where a.nombre=?1";
		TypedQuery<Alumno> tquery=entityManager.createQuery(jpql,Alumno.class);
		tquery.setParameter(1, nombre);
		return tquery.getResultList().size()==1?Optional.of(tquery.getResultList().get(0)):Optional.empty();
		
	}

	@Override
	public Set<Alumno> alumnosCurso(String curso) {
		List<Alumno> lista;
		String jpql="select a from Alumno a where a.curso=?1";
		/*Query query=entityManager.createQuery(jpql);
		query.setParameter(1, curso);
		lista=(List<Alumno>)query.getResultList();*/
		TypedQuery<Alumno> tquery=entityManager.createQuery(jpql,Alumno.class);
		tquery.setParameter(1, curso);
		lista=tquery.getResultList();
		return new HashSet<Alumno>(lista);
	}
	@Transactional(propagation = Propagation.REQUIRED)
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
