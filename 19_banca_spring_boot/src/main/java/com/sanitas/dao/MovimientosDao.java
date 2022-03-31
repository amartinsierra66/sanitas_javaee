package com.sanitas.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanitas.model.Movimiento;

public interface MovimientosDao extends JpaRepository<Movimiento, Integer> {
	@Query("select m from Movimiento m where m.cuenta.numeroCuenta=:idCuenta")
	List<Movimiento> findMovimientosByCuenta(@Param("idCuenta") int idCuenta);
	@Query("select m from Movimiento m join m.cuenta.clientes c where c.dni=:dni")
	List<Movimiento> findMovimientosByCliente(@Param("dni") int dni);
}
