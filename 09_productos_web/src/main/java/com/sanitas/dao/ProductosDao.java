package com.sanitas.dao;

import java.util.List;

import com.sanitas.model.Producto;

public interface ProductosDao {
	Producto save(Producto producto);
	void update(Producto producto);
	Producto findById(int idProducto);
	Producto findByNombre(String nombre);
	List<Producto> findAll();
	List<Producto> findBySeccion(String seccion);	
} 
