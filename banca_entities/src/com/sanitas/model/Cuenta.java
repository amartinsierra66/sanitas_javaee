package com.sanitas.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cuentas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Cuenta {
	@Id
	private int numeroCuenta;
	private double saldo;
	@Column(name = "tipocuenta")
	private String tipoCuenta;
	@ManyToMany(mappedBy = "cuentas")
	private List<Cliente> clientes;
	@OneToMany(mappedBy = "cuenta")
	private List<Movimiento> movimientos;
}
