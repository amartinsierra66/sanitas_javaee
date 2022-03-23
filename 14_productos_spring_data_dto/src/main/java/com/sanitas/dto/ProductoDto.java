package com.sanitas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductoDto {
	@JsonProperty("nombre")
	private String producto;
	@JsonProperty("seccion")
	private String categoria;
	private double precio;
	private int stock;
	
	
	
}
