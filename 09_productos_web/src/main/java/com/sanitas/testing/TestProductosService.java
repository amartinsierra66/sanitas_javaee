package com.sanitas.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sanitas.config.ModelConfig;
import com.sanitas.dao.ProductosDao;
import com.sanitas.model.Producto;
import com.sanitas.service.ProductosService;
import com.sanitas.service.ProductosServiceImpl;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@ContextConfiguration(classes = { ModelConfig.class })
public class TestProductosService {
	@Mock
	ProductosDao dao;
	
	ProductosService service;
	@BeforeEach
	void init() {
		service=new ProductosServiceImpl(dao);
		when(dao.findAll())
		.thenReturn(List.of(new Producto(1,"p1","sa",100,10),
				new Producto(2,"p2","sa",20,5),
				new Producto(3,"p3","sb",30,8),
				new Producto(4,"p4","sc",50,2)));
		/*when(dao.findById(1))
		.thenReturn(new Producto(1,"p1","sa",100,10));*/
		when(dao.findByNombre("p3"))
		.thenReturn(new Producto(3,"p3","sb",30,8));
		when(dao.findByNombre("none"))
		.thenReturn(null);
		lenient().when(dao.findBySeccion("sa"))
		.thenReturn(List.of(new Producto(1,"p1","sa",100,10),
							new Producto(2,"p2","sa",20,5)));
		lenient().when(dao.findBySeccion("test"))
		.thenReturn(List.of());		
	}
	
	@Test
	void testProductosSeccion() {
		
		assertEquals(4, service.productosSeccion(null).size());
		assertEquals(2, service.productosSeccion("sa").size());
		assertEquals(0, service.productosSeccion("test").size());
	}
	
	@Test
	void testBuscarProducto() {
		init();
		//assertEquals(100, service.obtenerProducto("mesa").get().getPrecio());
		assertTrue(service.obtenerProducto("p3").isPresent());
		assertFalse(service.obtenerProducto("none").isPresent());
	}
	
	@Test
	void testListaSecciones() {
		init();
		assertEquals(3, service.secciones().size());
	}
	
}
