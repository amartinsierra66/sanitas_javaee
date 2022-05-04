package com.sanitas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sanitas.model.Alumno;
@Repository
public class AlumnosDaoImpl implements AlumnosDao {
	@PersistenceContext
	EntityManager entityManager;
	@Transactional
	@Override
	public void save(Alumno al) {
		entityManager.persist(al);

	}
	@Transactional
	@Override
	public void remove(Alumno al) {
		entityManager.remove(al);

	}

	@Override
	public Alumno findById(int idAlumno) {
		return entityManager.find(Alumno.class, idAlumno);
	}

	@Override
	public Alumno findByNombre(String nombre) {
		String jpql="Select a from Alumno a where a.nombre=?1";
		TypedQuery<Alumno> tquery=entityManager.createQuery(jpql,Alumno.class);
		tquery.setParameter(1, nombre);
		/*List<Alumno> alumnos=tquery.getResultList();
		return alumnos.size()>0?alumnos.get(0):null;*/
		try {
			return tquery.getSingleResult();
		}
		catch(NonUniqueResultException|NoResultException ex) {
			return null;
		}
	}

	@Override
	public List<Alumno> findByCurso(String curso) {
		//String jpql="Select a from Alumno a where a.curso=?1";
		CriteriaBuilder builder=entityManager.getCriteriaBuilder();
		CriteriaQuery<Alumno> cquery=builder.createQuery(Alumno.class);
		Root<Alumno> root=cquery.from(Alumno.class);
		CriteriaQuery<Alumno> query=cquery.select(root).where(builder.equal(root.get("curso"), curso));
		TypedQuery<Alumno> tquery=entityManager.createQuery(query);
		return tquery.getResultList();
		
	}
	@Transactional
	@Override
	public void deleteByCurso(String curso) {
		String jpql="delete from Alumno a where a.curso=?1";
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, curso);
		query.executeUpdate();
	}
	@Override
	public List<Alumno> findAll() {
		
		TypedQuery<Alumno> tquery=entityManager.createQuery(criteriaBase());
		return tquery.getResultList();
	}
	
	private CriteriaQuery<Alumno> criteriaBase(){
		CriteriaBuilder builder=entityManager.getCriteriaBuilder();
		CriteriaQuery<Alumno> cquery=builder.createQuery(Alumno.class);
		Root<Alumno> root=cquery.from(Alumno.class);
		return cquery.select(root);
	}

}
