package com.sanitas.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sanitas.model.Pagina;
import com.sanitas.service.BuscadorService;

@Controller
public class BuscadorController {
	@Autowired
	@Qualifier(value = "buscadorServiceImpl") //imprescindible si hay más de una clase que implementa la interfaz
	BuscadorService buscadorService;
	@GetMapping("buscar")
	public String buscar(@RequestParam("clave") String clave,HttpServletRequest request) {
		List<Pagina> paginas=buscadorService.buscarPorTematica(clave);
		//almacenamos la lista de páginas en un atributo de petición
		//para que la vista (página JSP) tenga acceso al mismo
		request.setAttribute("paginas", paginas);
		//devuelve la dirección de la página a la que hay que transferir el control
		return "direcciones";
	}
}
