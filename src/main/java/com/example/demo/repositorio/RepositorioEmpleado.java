package com.example.demo.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.modelo.Empleado;

@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado, Long>{
	 public List<Empleado> findByNombre(String nombre);
	 public Empleado findByEmail(String email);
	 public List<Empleado> findByApellido(String apellido);
	 
	 public List<Empleado> deleteByNombre(String nombre);
	 public Empleado deleteByEmail(String email);
	 public List<Empleado> deleteByApellido(String apellido);
	 
	 
}
