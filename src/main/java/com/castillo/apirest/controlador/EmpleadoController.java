package com.castillo.apirest.controlador;

import com.castillo.apirest.Excepciones.EmpleadoNoEncontradoException;
import com.castillo.apirest.dominio.Empleado;
import com.castillo.apirest.repositorio.EmpleadoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpleadoController {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoController(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @GetMapping("/empleados")
    List<Empleado> obtenerTodos() {
        return empleadoRepository.findAll();
    }

    @PostMapping("/empleados")
    Empleado nuevoEmpleado(@RequestBody Empleado nuevoEmpleado) {
        return empleadoRepository.save(nuevoEmpleado);
    }

    @GetMapping("empleados/{id}")
    Empleado buscarEmpleado(@PathVariable Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new EmpleadoNoEncontradoException(id));
    }

    @PutMapping("empleados/{id}")
    Empleado actualizarEmpleado(@RequestBody Empleado empleadoActualizado, @PathVariable Long id) {
        return empleadoRepository.findById(id)
                .map(empleado -> {
                    empleado.setNombre(empleadoActualizado.getNombre());
                    empleado.setRol(empleadoActualizado.getRol());
                    return empleadoRepository.save(empleado);
                }).orElseGet(() -> {
                    empleadoActualizado.setId(id);
                    return empleadoRepository.save(empleadoActualizado);
                });
    }

    @DeleteMapping("empleados/{id}")
    void eliminarEmpleado(@PathVariable Long id) {
        empleadoRepository.deleteById(id);
    }
}

