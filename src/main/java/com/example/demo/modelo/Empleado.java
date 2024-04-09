package com.example.demo.modelo;

import jakarta.persistence.*;


@Entity
@Table(name="empleados")
public class Empleado {
  @Id
  @Column(name="identificacion")
  private Long identificacion;
  
  @Column(name="nombre", length = 60, nullable = false)
  private String nombre;
  
  @Column(name="apellido", length = 80, nullable = false)
  private String apellido;
  
  @Column(name="email", length = 100, nullable = false, unique=true)
  private String email;
  
  

public Empleado() {
	super();
	// TODO Auto-generated constructor stub
}

public Empleado(Long identificacion, String nombre, String apellido, String email) {
	super();
	this.identificacion = identificacion;
	this.nombre = nombre;
	this.apellido = apellido;
	this.email = email;
}

public Long getIdentificacion() {
	return identificacion;
}

public void setIdentificacion(Long identificacion) {
	this.identificacion = identificacion;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getApellido() {
	return apellido;
}

public void setApellido(String apellido) {
	this.apellido = apellido;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
  
  
  
  
  
}
