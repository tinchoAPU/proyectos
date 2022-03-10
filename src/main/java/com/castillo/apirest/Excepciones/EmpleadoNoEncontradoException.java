package com.castillo.apirest.Excepciones;

public class EmpleadoNoEncontradoException extends RuntimeException{
    public EmpleadoNoEncontradoException(Long id){
        super("No se encontro el empleado : " + id);
    }
}
