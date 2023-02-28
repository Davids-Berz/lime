package com.lime.patrones.factory;

abstract public class PizzeriaZonaAF {

    public PizzaProducto ordenarPizza(String tipo) {
        PizzaProducto pizza = crearPizza(tipo);
        System.out.println("Fabricando la pizza " + pizza.getNombre());
        pizza.preparar();
        pizza.cocinar();
        pizza.cortar();
        pizza.empaquetar();
        return pizza;

    }

    protected abstract PizzaProducto crearPizza(String tipo);
}
