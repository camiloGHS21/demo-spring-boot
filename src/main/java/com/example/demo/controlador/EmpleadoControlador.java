package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.modelo.Empleado;
import com.example.demo.repositorio.RepositorioEmpleado;

@RestController
@RequestMapping("/ver/e1/")
public class EmpleadoControlador {
	
  @Autowired
  private RepositorioEmpleado repositorio;
  

@GetMapping("/empleados")
  public List<Empleado> verTodosEmpleados(){
	  return repositorio.findAll();
  }
 
@GetMapping("/guardar")
public Empleado guardarEmpleado( ){
	Empleado empleado = new Empleado(1234L,"grajales","camiloghs1@gmail.com","camilo");
    return repositorio.save(empleado);
}
@GetMapping("/buscar")
public Empleado verUnEmpleado() {
	//return repositorio.findById(1234L);
	return repositorio.findByEmail("carito@gmail.com");
}

@GetMapping("/buscar-por-nombre")
public List<Empleado> buscarPorNombre() {
    return repositorio.findByNombre("camilo");
}

@GetMapping("/buscar-por-apellido")
public List<Empleado> buscarPorApellido() {
    return repositorio.findByApellido("grajales");
}


@GetMapping("/eliminar")
public String eliminarEmpleado(){
	//repositorio.deleteById(1234L);
	repositorio.deleteByEmail("camiloghs1@gmail.com");
	return "empleado eliminado";
}

@GetMapping("/eliminar-por-nombre")
public String eliminarPorNombre() {
	repositorio.deleteByNombre("camilo");
	return "eliminar por nombre";
}

@GetMapping("/eliminar-por-apellido")
public String eliminarPorApellido() {
	repositorio.deleteByApellido("grajales");
	return "eliminar por apellido";
}

@GetMapping("/actualizar")
public String actualizarEmpleado() {
	Empleado e = repositorio.findById(1258L).get();
	
	e.setApellido("Melisa");
	repositorio.save(e);
	return "apellido del empleado actualizado";
}

@GetMapping("/actualizar-por-nombres")
public String actualizarPorNombre() {
    List<Empleado> empleado = repositorio.findByNombre("camilo");
    repositorio.saveAll(empleado);
    return "empleado actualizado por el nombres";
   
}

@GetMapping("/actualizar-por-apellidos")
public String actualizarPorApellido() {
    List<Empleado> empleado = repositorio.findByApellido("grajales");
    repositorio.saveAll(empleado);
    return "empleado actualizado por el apellidos";
   
}

@GetMapping("/actualizar-por-email")
public String actualizarPorEmail() {
     Empleado empleado = repositorio.findByEmail("camiloghs1@gmail.com");
    repositorio.save(empleado);
    return "empleado actualizado por el email";
   
}


}
