package com.sanitas.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanitas.converters.Converter;
import com.sanitas.dao.ClientesDao;
import com.sanitas.dao.CuentasDao;
import com.sanitas.dao.MovimientosDao;
import com.sanitas.dtos.ClienteDto;
import com.sanitas.dtos.CuentaDto;
import com.sanitas.dtos.MovimientoDto;
@Service
public class CajeroServiceImp implements CajeroService {
	
	ClientesDao clientesDao;

	CuentasDao cuentasDao;

	MovimientosDao movimientosDao;
	
	Converter converter;
	
	public CajeroServiceImp(@Autowired ClientesDao clientesDao,
			@Autowired	CuentasDao cuentasDao,
			@Autowired	MovimientosDao movimientosDao,
			@Autowired Converter converter) {
		this.clientesDao=clientesDao;
		this.cuentasDao=cuentasDao;
		this.movimientosDao=movimientosDao;
		this.converter=converter;
	}
	@Override
	public List<ClienteDto> clientes() {
		return clientesDao.findAll()
				.stream()
				.map(c->converter.clienteToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<CuentaDto> cuentasCliente(int dni) {
		return cuentasDao.findCuentasByCliente(dni)
				.stream()
				.map(c->converter.cuentaToDto(c))
				.collect(Collectors.toList());
	}

	@Override
	public List<MovimientoDto> movimientosCuenta(int numeroCuenta) {
		return movimientosDao.findMovimientosByCuenta(numeroCuenta)
				.stream()
				.map(c->converter.movimientoToDto(c))
				.collect(Collectors.toList());
	}

}
