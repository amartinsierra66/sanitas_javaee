package com.sanitas.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="clientes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cliente {
	@Id
	private int dni;
	private String nombre;
	private String direccion;
	private int telefono;
	@ManyToMany()
	@JoinTable(name = "titulares",  
	                   joinColumns =
	                       @JoinColumn(name="idCliente",
	                                            referencedColumnName = "dni"), 
	                   inverseJoinColumns =
	                       @JoinColumn(name="idCuenta",
	                                          referencedColumnName ="numeroCuenta"))
	private List<Cuenta> cuentas=new ArrayList<>();
}
