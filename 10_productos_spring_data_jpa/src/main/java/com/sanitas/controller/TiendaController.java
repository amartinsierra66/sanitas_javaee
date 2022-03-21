package com.sanitas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sanitas.model.Producto;
import com.sanitas.service.ProductosService;

@CrossOrigin("*")
@Controller
public class TiendaController {
	
	ProductosService productosService;
	public TiendaController(@Autowired ProductosService productosService) {
		this.productosService=productosService;
	}
	@PostMapping(value="alta",produces=MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String alta(@ModelAttribute Producto producto) {	
		return "stock actual: "+productosService.altaProducto(producto);
	}
	
	
	@GetMapping(value="buscar", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Producto buscarProducto(@RequestParam("nombre") String nombre) {
		Optional<Producto> res=productosService.obtenerProducto(nombre);
		return res.isEmpty()?null:res.get();
	}
	@GetMapping(value="productos", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Producto> productosSeccion(@RequestParam("seccion") String seccion){
		return productosService.productosSeccion(seccion);
	}
	
	@GetMapping(value="secciones", produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<String> secciones(){
		return productosService.secciones();
	}
	
}
