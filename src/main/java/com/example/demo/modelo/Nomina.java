package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Nomina")
public class Nomina {
	  public Nomina() {
		super();
	}

	  @Id
	  @GeneratedValue(strategy = GenerationType.SEQUENCE)
	  @Column(name="idNomina")
	  private Long idNomina;
	  
      @Column(name="mes")
      private String mes;
      
      @Column(name="salario")
      private Long salario;
      
      @ManyToOne()
      @JoinColumn(name= "identificacion" , referencedColumnName="identificacion")
      private Empleado empleado;

	public Long getIdNomina() {
		return idNomina;
	}

	public void setIdNomina(Long idNomina) {
		this.idNomina = idNomina;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public Long getSalario() {
		return salario;
	}

	public void setSalario(Long salario) {
		this.salario = salario;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	

	public Nomina( String mes, Long salario, Empleado empleado) {
		super();
		this.mes = mes;
		this.salario = salario;
		this.empleado = empleado;
	}

	  

}
