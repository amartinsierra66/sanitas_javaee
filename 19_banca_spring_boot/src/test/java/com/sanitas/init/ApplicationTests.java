package com.sanitas.init;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sanitas.service.CajeroService;

@SpringBootTest
class ApplicationTests {

	@Autowired
	CajeroService cajeroService;
	
	
	@Test
	void testCliente() {
		assertEquals(6, cajeroService.clientes().size());
	}
	@Test
	void testCuentasCliente() {
		assertEquals(3, cajeroService.cuentasCliente(1111).size());
	}
	
	@Test
	void testMovimientosCuenta() {
		assertEquals(11, cajeroService.movimientosCuenta(2000).size());
		assertEquals(0, cajeroService.movimientosCuenta(7000).size());
	}

}
