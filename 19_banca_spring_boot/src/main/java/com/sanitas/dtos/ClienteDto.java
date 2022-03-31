package com.sanitas.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore //no convierte a JSON la propiedad indicada
	private List<CuentaDto> cuentas;
}
