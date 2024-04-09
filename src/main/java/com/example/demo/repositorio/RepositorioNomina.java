package com.example.demo.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Nomina;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioNomina extends JpaRepository<Nomina, Long> {
   public Nomina findByMes(String mes);
   public List<Nomina> findBySalario(long salario);
   public List<Nomina> findByEmpleado(Empleado e); 
   
   public Nomina deleteByMes(String mes);
   public List<Nomina> deleteBySalario(long salario);
   public List<Nomina> deleteByEmpleado(Empleado e); 
   
}
