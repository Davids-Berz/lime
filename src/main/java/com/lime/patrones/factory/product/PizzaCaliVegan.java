package com.lime.patrones.factory.product;

import com.lime.patrones.factory.PizzaProducto;

public class PizzaCaliVegan extends PizzaProducto {

    public PizzaCaliVegan() {
        super();
        nombre = "Pizza Vegan Cali";
        masa = "Masa Integral vegana Cali";
        salsa = "Salsa de tomate";
        ingredientes.add("Queso vegano");
        ingredientes.add("Tomate");
        ingredientes.add("aceitunas");
        ingredientes.add("espinacas");
    }

    @Override
    public void cocinar() {
        System.out.println("cocinando por 25min a 180°C");
    }

    @Override
    public void cortar() {
        System.out.println("Cortando la pizza en rebanadas cuadradas");
    }
}
