package com.lime.poo.interfaces.entity;

import java.util.Objects;

public class Cliente {

    public Cliente() {
        this.id = ++identity;
    }

    public Cliente(String nombre) {
        this.id = ++identity;
        this.nombre = nombre;
    }

    private Integer id;
    private String nombre;

    private static Integer identity = 0;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "id: " + id + " nombre: " + nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id.equals(cliente.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
