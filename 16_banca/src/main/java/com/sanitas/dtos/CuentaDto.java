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
public class CuentaDto {
	private int numeroCuenta;
	private double saldo;
	private String tipo;
}
