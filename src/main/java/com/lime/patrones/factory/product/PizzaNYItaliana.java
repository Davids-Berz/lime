package com.lime.patrones.factory.product;

import com.lime.patrones.factory.PizzaProducto;

public class PizzaNYItaliana extends PizzaProducto {

    public PizzaNYItaliana() {
        super();
        nombre = "Pizza italiana  NY";
        masa = "Masa gruesa";
        salsa = "Salsa de tomate con carne";
        ingredientes.add("Jamon");
        ingredientes.add("Chorizo");
        ingredientes.add("Queso mozzarela");
        ingredientes.add("Jamon");
    }

    @Override
    public void cocinar() {
        System.out.println("Cocinando por 30 min");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la piza en 8 triangulos");
    }
}
