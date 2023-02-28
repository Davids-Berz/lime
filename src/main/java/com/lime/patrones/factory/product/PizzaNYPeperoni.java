package com.lime.patrones.factory.product;

import com.lime.patrones.factory.PizzaProducto;

public class PizzaNYPeperoni extends PizzaProducto {

    public PizzaNYPeperoni() {
        super();
        nombre = "Pizza Peperoni NY";
        masa = "mada delgada a piedra";
        salsa = "salsa de tomate";
        ingredientes.add("peperoni");
        ingredientes.add("queso manchego");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 15 min a 90°C");
    }

    @Override
    public void cortar() {
        System.out.println("cortando la pizza en triangulos");
    }
}
