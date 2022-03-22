package com.sanitas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanitas.model.Producto;

public interface ProductosDao extends JpaRepository<Producto,Integer>{	
	Producto findByNombre(String nombre);
	List<Producto> findBySeccion(String seccion);	
} 
