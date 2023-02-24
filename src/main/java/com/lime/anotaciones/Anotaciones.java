package com.lime.anotaciones;

import com.lime.anotaciones.entity.Producto;
import com.lime.anotaciones.procesador.JsonUtils;

public class Anotaciones {

    public static void main(String[] args) {

        Producto producto = Producto.getInstanceProducto();

        producto.setNombre("apartamento");
        producto.setPrecio(10l);


        String json = JsonUtils.convertJson(producto);

        System.out.println(json);
    }
}
