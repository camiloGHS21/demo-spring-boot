package com.example.demo.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Nomina;
import com.example.demo.repositorio.RepositorioEmpleado;
import com.example.demo.repositorio.RepositorioNomina;

@RestController
@RequestMapping("/ver/n1/")
public class NominaControlador {
	  @Autowired
	  private RepositorioNomina repositorio;
	  
	  @Autowired
	  private RepositorioEmpleado empleadoRepository;
	  

	@GetMapping("/nominas")
	  public List<Nomina> verTodosEmpleados(){
		  return repositorio.findAll();
	  }
	 
	  @GetMapping("/guardar")
	    public String guardarEmpleado() {
	        Empleado empleado = empleadoRepository.findById(1234L).orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
	        
	        Nomina nomina = new Nomina("Marzo", 1500000L, empleado);
	        repositorio.save(nomina);
	        return "nomina guardada";
	    }
	  
	  @GetMapping("/buscar")
	  public Nomina buscarNomina() {
		  //return repositorio.findById(1L);
		  return repositorio.findByMes("Mayo");
		  
	  }
	  
	  @GetMapping("buscar-salarios")
	 public  List<Nomina> BuscarSalarios() {
		  return repositorio.findBySalario(1000000L);
	  }

	  @GetMapping("/buscarNominasEmpleado")
		 public List<Nomina> buscarEmpleados() {
			 Empleado e= empleadoRepository.findById(1234l).get();
			 return repositorio.findByEmpleado(e);
			
		 }
	  
	  @GetMapping("/eliminar")
	  public String eliminarNomina() {
		  repositorio.deleteById(2L);
			return "Nomina 2 eliminado";
	  }
	  @GetMapping("/eliminar-por-mes")
	  public String eliminarNominaPorMes() {
		  repositorio.deleteByMes("Marzo");
			return "eliminado Nomina por mes";
	  }
	  @GetMapping("/eliminar-por-salarios")
	  public String eliminarNominaPorSalarios() {
		  repositorio.deleteBySalario(1500000L);
			return "eliminado Nomina por salario";
	  }
	  
	  @GetMapping("/actualizar")
	  public String actualizarEmpleado() {
	  	Nomina e = repositorio.findById(1L).get();
	  	e.setSalario(1500000L);
	  	repositorio.save(e);
	  	return "pricio de Nomina 1 actualizado";
	  }
	  
	  @GetMapping("/actualizar-por-salarios")
	  public String actualizarPorSalarios() {
	      List<Nomina> empleado = repositorio.findBySalario(1000000L);
	      repositorio.saveAll(empleado);
	      return "actualizado nominas por el salarios";
	     
	  }
	  
	  @GetMapping("/actualizar-por-mes")
	  public String actualizarPorMes() {
		  Nomina empleado = repositorio.findByMes("Marzo");
	      repositorio.save(empleado);
	      return "actualizado nominas por el mes";
	     
	  }
	
}
