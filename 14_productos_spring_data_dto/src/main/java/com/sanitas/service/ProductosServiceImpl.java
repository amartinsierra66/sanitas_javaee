package com.sanitas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanitas.converters.ProductoConverter;
import com.sanitas.dao.ProductosDao;
import com.sanitas.dto.ProductoDto;
import com.sanitas.model.Producto;
@Service
public class ProductosServiceImpl implements ProductosService {
	@Autowired
	ProductoConverter productoConverter;
	
	ProductosDao productosDao;
	
	public ProductosServiceImpl(@Autowired	ProductosDao productosDao) {
		this.productosDao=productosDao;
	}
	@Override
	public int altaProducto(ProductoDto producto) {
		productosDao.save(productoConverter.dtoToProducto(producto));
		return producto.getStock();
	}

	@Override
	public List<ProductoDto> productosSeccion(String seccion) {
		List<Producto> productos;
		if(seccion==null||seccion.equals("")) {
			productos= productosDao.findAll();
		}else {
			productos= productosDao.findBySeccion(seccion);
		}
		return productos.stream()
				.map(p->productoConverter.productoToDto(p))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<ProductoDto> obtenerProducto(String nombre) {
		return Optional.ofNullable(productoConverter.productoToDto(productosDao.findByNombre(nombre)));
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
