package com.sanitas.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ProductoDto {
	@JsonProperty("nombre")
	private String producto;
	@JsonProperty("seccion")
	private String categoria;
	private double precio;
	private int stock;
	/**
	 * @param producto
	 * @param categoria
	 * @param precio
	 * @param stock
	 */
	/*
	 * public ProductoDto(String producto, String categoria, double precio, int
	 * stock) { super(); this.producto = producto; this.categoria = categoria;
	 * this.precio = precio; this.stock = stock; } public ProductoDto() { super(); }
	 * public String getProducto() { return producto; } public void
	 * setProducto(String producto) { this.producto = producto; } public String
	 * getCategoria() { return categoria; } public void setCategoria(String
	 * categoria) { this.categoria = categoria; } public double getPrecio() { return
	 * precio; } public void setPrecio(double precio) { this.precio = precio; }
	 * public int getStock() { return stock; } public void setStock(int stock) {
	 * this.stock = stock; }
	 */
	
}
