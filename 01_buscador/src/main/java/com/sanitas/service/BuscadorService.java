package com.sanitas.service;

import java.util.List;

import com.sanitas.model.Pagina;

public interface BuscadorService {

	List<Pagina> buscarPorTematica(String clave);

}