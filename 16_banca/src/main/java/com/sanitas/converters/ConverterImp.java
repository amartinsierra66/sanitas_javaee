package com.sanitas.converters;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.sanitas.dtos.ClienteDto;
import com.sanitas.dtos.CuentaDto;
import com.sanitas.dtos.MovimientoDto;
import com.sanitas.model.Cliente;
import com.sanitas.model.Cuenta;
import com.sanitas.model.Movimiento;
@Component
public class ConverterImp implements Converter {

	@Override
	public ClienteDto clienteToDto(Cliente cliente) {
		return new ClienteDto(cliente.getDni(),
							cliente.getNombre(),
							cliente.getDireccion(),
							cliente.getTelefono(),
							cliente.getCuentas()
							.stream()
							.map(c->cuentaToDto(c))
							.collect(Collectors.toList())
				);
	}

	@Override
	public Cliente dtoToCliente(ClienteDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CuentaDto cuentaToDto(Cuenta cuenta) {
		return new CuentaDto(cuenta.getNumeroCuenta(),cuenta.getSaldo(),cuenta.getTipoCuenta());
	}

	@Override
	public Cuenta dtoToCuenta(CuentaDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovimientoDto movimientoToDto(Movimiento movimiento) {
		return new MovimientoDto(movimiento.getCantidad(),
								movimiento.getFecha(),
								cuentaToDto(movimiento.getCuenta()));
	}

	@Override
	public Movimiento dtoToMovimiento(MovimientoDto dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
