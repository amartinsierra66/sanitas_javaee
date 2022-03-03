package com.sanitas.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sanitas.model.Alumno;
@Service
public class AlumnosServiceImpl implements AlumnosService {
	private ArrayList<Alumno> alumnos=new ArrayList<>();
	//recoge alumno y lo guarda
	   @Override
	public void agregarAlumno (Alumno alumno) {
		   alumnos.add(alumno);
	    }
	    @Override
		public void agregarAlumno (String nombre, String curso, double nota) {
	        Alumno alumno = new Alumno(nombre, curso, nota);
	        agregarAlumno(alumno);
	    }
	    //devuelve la nota media global
	    @Override
		public double media() {
	       return alumnos.stream()
	       .mapToDouble(a->a.getNota()) //transforma cada alumno en su nota double
	       .average()
	       .orElse(0.0);
	    }
	    @Override
		public int aprobados() {
	    	return (int)alumnos.stream()
	    			.filter(a->a.getNota()>=5)
	    			.count();
	    }
	    @Override
		public double notaAlta() {
	    	return alumnos.stream()
	    			.mapToDouble(a->a.getNota())
	    			.max()
	    			.orElse(0.0);
	    }
	    
	    @Override
		public boolean alumnoNotaMayor(double nota) {
	    	return alumnos.stream()
	    			.anyMatch(a->a.getNota()>=nota);
	    }
	    
	    
	    @Override
		public Alumno alumnoNotaMasAlta() {
	    	return alumnos.stream()
	    			.max(Comparator.comparing(a->a.getNota()))
	    			.orElse(null);
	    }
	    
	    @Override
		public Alumno buscarAlumnoPorNombre(String nombre) {
	    	return alumnos.stream()
	    			.filter(a->a.getNombre().equals(nombre))
	    			.findFirst()
	    			.orElse(null);
	    }
	    
	    @Override
		public HashSet<Alumno> alumnosCurso(String curso){
	        /*HashSet<Alumno> alumnosC = new HashSet<Alumno>();
	        for(Alumno alumno:alumnos) {
	            if(alumno.getCurso().equals(curso)) {
	                alumnosC.add(alumno);
	            }
	        }
	        return alumnosC;*/
	    	return new HashSet<Alumno>(alumnos.stream()
	    			.filter(a->a.getCurso().equals(curso))
	    			.collect(Collectors.toSet()));
	    	
	    }
}
