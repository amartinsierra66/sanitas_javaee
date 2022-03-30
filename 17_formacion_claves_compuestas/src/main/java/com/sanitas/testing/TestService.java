package com.sanitas.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.sanitas.config.ModelConfig;
import com.sanitas.service.MatriculacionesService;

@ExtendWith(SpringExtension.class)

@ContextConfiguration(classes = { ModelConfig.class })
public class TestService {
	@Autowired
	MatriculacionesService service;
	
	@Test
	void testMatriculasCurso() {
		assertEquals(4, service.matriculacionesCurso(17).size());
	}
	
}
