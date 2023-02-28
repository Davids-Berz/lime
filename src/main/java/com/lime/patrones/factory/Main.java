package com.lime.patrones.factory;

import com.lime.patrones.factory.product.PizzaNYPeperoni;
import com.lime.patrones.factory.zone.PizzeriaCaliAF;
import com.lime.patrones.factory.zone.PizzeriaNYF;

public class Main {

    public static void main(String[] args) {

        PizzeriaZonaAF ny = new PizzeriaNYF();
        PizzeriaZonaAF cali = new PizzeriaCaliAF();
        PizzaProducto pizza = null;


        pizza = ny.ordenarPizza("vegan");
        System.out.println("David ordena la piza " + pizza.toString());


    }
}
