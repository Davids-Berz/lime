package com.lime.patrones.factory.zone;

import com.lime.patrones.factory.PizzaProducto;
import com.lime.patrones.factory.PizzeriaZonaAF;
import com.lime.patrones.factory.product.PizzaNYItaliana;
import com.lime.patrones.factory.product.PizzaNYPeperoni;
import com.lime.patrones.factory.product.PizzaNYVegan;

public class PizzeriaNYF extends PizzeriaZonaAF {

    @Override
    protected PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = null;


        switch (tipo) {
            case "vegan":
                producto = new PizzaNYVegan();
                break;
            case "peperoni":
                producto = new PizzaNYPeperoni();
                break;
            case "italiana":
                producto = new PizzaNYItaliana();
                break;
        }
        return producto;
    }
}
