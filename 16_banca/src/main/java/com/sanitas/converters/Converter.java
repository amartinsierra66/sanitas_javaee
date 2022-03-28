package com.sanitas.converters;

import com.sanitas.dtos.ClienteDto;
import com.sanitas.dtos.CuentaDto;
import com.sanitas.dtos.MovimientoDto;
import com.sanitas.model.Cliente;
import com.sanitas.model.Cuenta;
import com.sanitas.model.Movimiento;

public interface Converter {
	ClienteDto clienteToDto(Cliente cliente);
	Cliente dtoToCliente(ClienteDto dto);
	
	CuentaDto cuentaToDto(Cuenta cuenta);
	Cuenta dtoToCuenta(CuentaDto dto);
	
	MovimientoDto movimientoToDto(Movimiento movimiento);
	Movimiento dtoToMovimiento(MovimientoDto dto);
}
