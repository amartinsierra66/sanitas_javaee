package com.sanitas.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sanitas.model.Cliente;

public interface ClientesDao extends JpaRepository<Cliente, Integer> {
	@Query("select distinct(c) from Cliente c join fetch c.cuentas ct")
	List<Cliente> findAll();
	
	@Query("select c from Cliente c join c.cuentas ct where ct.numeroCuenta=:idCuenta")
	List<Cliente> findClientesByCuenta(@Param("idCuenta") int idCuenta);
	@Query("select c from Cliente c join c.cuentas ct join ct.movimientos m where m.fecha=:fecha")
	List<Cliente> findClientesByFechaOperacion(@Param("fecha") Date fecha);
}
