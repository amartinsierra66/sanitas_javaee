package com.sanitas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanitas.model.Cuenta;

public interface CuentasDao extends JpaRepository<Cuenta, Integer> {
	@Query("select c From Cuenta c join c.clientes cli where cli.dni=:dni")
	List<Cuenta> findCuentasByCliente(@Param("dni") int dni);
}
