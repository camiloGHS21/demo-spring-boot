package com.example.demo.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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
	 
	 @Query(value ="SELECT e.nombre, SUM(n.salario) AS totalSalario FROM empleados e INNER JOIN nomina n GROUP BY e.nombre ",nativeQuery= true)
	   Optional<Object> calcularTotalNominaPorEmpleado();
	    
	 @Query(value ="SELECT n.mes, SUM(n.salario) AS totalSalario FROM nomina n GROUP BY n.mes;", nativeQuery= true)
	 List<Object> calcularTotalNominaPorEmpleadoMes();
    
	 @Query(value ="SELECT  count(e.nombre ) AS totalEmpleados FROM empleados e",nativeQuery= true)
	   Optional<Object> TotalEmpleados();
	 
	 @Query(value="SELECT e.nombre, count(n.salario) FROM empleado e inner join nomina n on e.identificacion = n.identificacion group by e.nombre",nativeQuery= true)
	 List<Object> cantidadPagoEmpleado();	 
	 
}
