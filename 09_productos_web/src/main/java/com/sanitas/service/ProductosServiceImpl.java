package com.sanitas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanitas.dao.ProductosDao;
import com.sanitas.model.Producto;
@Service
public class ProductosServiceImpl implements ProductosService {
	
	ProductosDao productosDao;
	
	public ProductosServiceImpl(@Autowired	ProductosDao productosDao) {
		this.productosDao=productosDao;
	}
	@Override
	public int altaProducto(Producto producto) {
		Producto prod=productosDao.findByNombre(producto.getNombre());
		if(prod==null) {
			productosDao.save(producto);
			return producto.getStock();
		}else {
			prod.setStock(prod.getStock()+producto.getStock());
			productosDao.update(prod);
			return prod.getStock();
		}
	}

	@Override
	public List<Producto> productosSeccion(String seccion) {
		if(seccion==null||seccion.equals("")) {
			return productosDao.findAll();
		}else {
			return productosDao.findBySeccion(seccion);
		}
	}

	@Override
	public Optional<Producto> obtenerProducto(String nombre) {
		return Optional.ofNullable(productosDao.findByNombre(nombre));
	}

	@Override
	public List<String> secciones() {
		return productosDao.findAll()
				.stream()
				.map(p->p.getSeccion())
				.distinct()
				.collect(Collectors.toList());
	}

}
