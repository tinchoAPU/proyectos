package com.castillo.apirest.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Empleado {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String rol;

    public Empleado(){}

    public Empleado(String nombre, String rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Empleado))
            return false;
        Empleado employee = (Empleado) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.nombre, employee.nombre)
                && Objects.equals(this.rol, employee.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.nombre, this.rol);
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + this.id + ", nombre='" + this.nombre + '\'' + ", rol='" + this.rol + '\'' + '}';
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
