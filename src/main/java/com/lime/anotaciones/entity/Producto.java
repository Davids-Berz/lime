package com.lime.anotaciones.entity;

import com.lime.anotaciones.JsonAttribute;
import com.lime.anotaciones.procesador.Init;

import java.util.function.Supplier;

public class Producto {

    @JsonAttribute(name = "nombre_producto")
    private String nombre;

    @JsonAttribute(name = "")
    private Long precio;


    @Init
    private void init() {
        this.nombre = String.valueOf(nombre.charAt(0)).toUpperCase()
                .concat(nombre.substring(1).toLowerCase());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public static Producto getInstanceProducto() {
        Supplier<Producto> producto = () -> new Producto();
        return producto.get();
    }
}
