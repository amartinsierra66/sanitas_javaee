package com.sanitas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sanitas.model.Producto;
@Repository
public class ProductosDaoImpl implements ProductosDao {
	@PersistenceContext
	EntityManager entityManager;
	@Transactional
	@Override
	public Producto save(Producto producto) {
		entityManager.persist(producto);
		return producto;
	}
	@Transactional
	@Override
	public void update(Producto producto) {
		entityManager.merge(producto);
	}

	@Override
	public Producto findById(int idProducto) {
		return entityManager.find(Producto.class, idProducto);
	}

	@Override
	public Producto findByNombre(String nombre) {
		String jpql="Select p from Producto p where p.nombre=?1";
		TypedQuery<Producto> tquery=entityManager.createQuery(jpql,Producto.class);
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
	public List<Producto> findAll() {
		String jpql="Select p from Producto p";
		TypedQuery<Producto> tquery=entityManager.createQuery(jpql,Producto.class);
		return tquery.getResultList();
	}

	@Override
	public List<Producto> findBySeccion(String seccion) {
		String jpql="Select p from Producto p where p.seccion=?1";
		TypedQuery<Producto> tquery=entityManager.createQuery(jpql,Producto.class);
		tquery.setParameter(1, seccion);
		return tquery.getResultList();
	}

}
