package com.sanitas.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="matriculas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Matricula {
	@EmbeddedId
	private MatriculaPk matriculaPk;
	private double nota;
	@ManyToOne
	@JoinColumn(name="idCurso",referencedColumnName = "idCurso",updatable = false, insertable = false)
	private Curso curso;
	@ManyToOne
	@JoinColumn(name="usuario",referencedColumnName = "usuario", updatable = false, insertable = false)
	private Alumno alumno;
	
}
