package com.sanitas.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteDto {
	private int dni;
	private String nombre;
	private String direccion;
	private int telefono;
	private List<CuentaDto> cuentas;
}
