package com.sanitas.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="alumnos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Alumno {
	@Id
	private String dni;
	private String nombre;
	private int edad;
	private String email;
	@ManyToOne()
	@JoinColumn(name="curso",referencedColumnName = "idCurso") //nombres de columna
	private Curso curso; 
}
