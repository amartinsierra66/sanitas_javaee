package com.sanitas.service;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sanitas.model.Alumno;
@Service
public class AlumnosServiceImpl implements AlumnosService {
	
	@Autowired
	@Qualifier("templateMySQL")
	JdbcTemplate template;

	@Override
	public void agregarAlumno(Alumno alumno) {
		agregarAlumno(alumno.getNombre(),alumno.getCurso(),alumno.getNota());
		
	}

	@Override
	public void agregarAlumno(String nombre, String curso, double nota) {
		String sql="insert into alumnos(nombre,curso,nota) value(?,?,?)";
		template.update(sql, nombre,curso,nota);		
	}

	@Override
	public double media() {
		String sql="select average(nota)  from alumnos";
		return template.query(sql, (ResultSet rs)->rs.getDouble(1));
	}

	@Override
	public int aprobados() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double notaAlta() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean alumnoNotaMayor(double nota) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Alumno alumnoNotaMasAlta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno buscarAlumnoPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Alumno> alumnosCurso(String curso) {
		String sql="select * from alumnos where curso=?";
		List<Alumno> lista=template.query(sql,(rs,fila)->new Alumno(rs.getInt("idAlumno"),
															rs.getString("nombre"),
															rs.getString("curso"),
															rs.getDouble("nota")) ,curso);
		//return Set.of(lista.toArray(new Alumno[0])); a partir de Java 9
		//return Set.copyOf(lista); //a partir de Java 10
		
		return new HashSet<>(lista);
	}
	
}
