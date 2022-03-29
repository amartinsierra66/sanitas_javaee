package com.sanitas.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date fecha;
	private String operacion;
	private CuentaDto cuenta;
}
