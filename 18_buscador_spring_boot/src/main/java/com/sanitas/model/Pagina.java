package com.sanitas.model;

public class Pagina {
	private String nombre;
	private String url;
	private String descripcion;
	private String[] claves;
	public Pagina(String nombre, String url, String[] claves, String descripcion ) {
		super();
		this.nombre = nombre;
		this.url = url;
		this.descripcion = descripcion;
		this.claves = claves;
	}
	public Pagina() {
		super();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String[] getClaves() {
		return claves;
	}
	public void setClaves(String[] claves) {
		this.claves = claves;
	}
	
}
