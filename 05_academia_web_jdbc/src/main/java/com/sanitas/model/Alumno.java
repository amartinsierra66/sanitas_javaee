package com.sanitas.model;

import java.util.Objects;

public class Alumno {
	private int idAlumno;
	private String nombre;
	private String curso;
	private double nota;
	public Alumno(String nombre, String curso, double nota) {
		this.nombre = nombre;
		this.curso = curso;
		this.nota = nota;
	}
	
	public Alumno(int idAlumno, String nombre, String curso, double nota) {
		super();
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.curso = curso;
		this.nota = nota;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	@Override
	public int hashCode() {
		return Objects.hash(curso, nombre, nota);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(curso, other.curso) && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(nota) == Double.doubleToLongBits(other.nota);
	}
	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", curso=" + curso + ", nota=" + nota + "]";
	}
	
	
	
}
