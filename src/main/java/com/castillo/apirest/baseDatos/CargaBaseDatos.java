package com.castillo.apirest.baseDatos;

import com.castillo.apirest.dominio.Empleado;
import com.castillo.apirest.repositorio.EmpleadoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CargaBaseDatos {

    private static final Logger log = LoggerFactory.getLogger(CargaBaseDatos.class);

    @Bean
    CommandLineRunner initBaseDatos(EmpleadoRepository empleadoRepository){
        return args -> {
            log.info("Preloading " + empleadoRepository.save(new Empleado("Bilbo Baggins", "burglar")));
            log.info("Preloading " + empleadoRepository.save(new Empleado("Frodo Baggins", "thief")));
        };
    }
}
