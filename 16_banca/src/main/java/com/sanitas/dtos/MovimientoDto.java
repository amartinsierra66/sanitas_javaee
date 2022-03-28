package com.sanitas.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MovimientoDto {
	private double cantidad;
	private Date fecha;
	private CuentaDto cuenta;
}
