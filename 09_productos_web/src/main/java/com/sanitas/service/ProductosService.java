package com.sanitas.service;

import java.util.List;
import java.util.Optional;

import com.sanitas.model.Producto;

public interface ProductosService {
	//devuelve el stock del producto
	int altaProducto(Producto producto);
	//devuelve la lista de productos a partir de la sección. Si la sección
	//es cadena vacía, que devuelva todos
	List<Producto> productosSeccion(String seccion);
	//devuelve el producto con ese nombre, si no existe, null
	Optional<Producto> obtenerProducto(String nombre);
	//devuelve una lista con los nombres de todas las secciones
	List<String> secciones();
	
}
