package com.lime.recursividad;


import java.util.ArrayList;
import java.util.List;

public class Componente {

    public Componente(String nombre) {
        this.nombre = nombre;
        this.hijos = new ArrayList<>();
    }

    private String nombre;

    List<Componente> hijos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Componente> getHijos() {
        return hijos;
    }

    public void setHijos(List<Componente> hijos) {
        this.hijos = hijos;
    }

    public Componente addComponent(Componente c) {
        this.hijos.add(c);
        return this;
    }

    public boolean tieneHijos() {
        return !hijos.isEmpty();
    }
}
