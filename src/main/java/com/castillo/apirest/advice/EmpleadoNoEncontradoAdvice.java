package com.castillo.apirest.advice;

import com.castillo.apirest.Excepciones.EmpleadoNoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class EmpleadoNoEncontradoAdvice {

    @ResponseBody
    @ExceptionHandler(EmpleadoNoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String manejadorEmpleadoNoEncontrado(EmpleadoNoEncontradoException exception){
        return exception.getMessage();
    }
}
