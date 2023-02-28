package com.lime.patrones.observer;

public class Corporacion extends Observable{

    public Corporacion(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    private String nombre;
    private int precio;

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void modificaPrecio(int precio) {
        this.precio = precio;
        notifyObservers();
    }
}
