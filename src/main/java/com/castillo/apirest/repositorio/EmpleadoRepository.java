package com.castillo.apirest.repositorio;

import com.castillo.apirest.dominio.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
