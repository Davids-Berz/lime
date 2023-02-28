package com.lime.patrones.factory.product;

import com.lime.patrones.factory.PizzaProducto;

public class PizzaNYVegan extends PizzaProducto {

    public PizzaNYVegan() {
        super();
        nombre = "Pizza Vegan NY";
        masa = "Masa Integral vegana NY";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso vegano");
        ingredientes.add("Tomate");
        ingredientes.add("aceitunas");
        ingredientes.add("espinacas");
    }

    @Override
    public void cocinar() {
        System.out.println("cocinando por 25min a 150°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas cuadradas");
    }
}
