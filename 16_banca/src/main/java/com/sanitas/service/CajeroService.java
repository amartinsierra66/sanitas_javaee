package com.sanitas.service;

import java.util.List;

import com.sanitas.dtos.ClienteDto;
import com.sanitas.dtos.CuentaDto;
import com.sanitas.dtos.MovimientoDto;

public interface CajeroService {
	List<ClienteDto> clientes();
	List<CuentaDto> cuentasCliente(int dni);
	List<MovimientoDto> movimientosCuenta(int numeroCuenta);
}
