package com.lime.patrones.factory.zone;

import com.lime.patrones.factory.PizzaProducto;
import com.lime.patrones.factory.PizzeriaZonaAF;
import com.lime.patrones.factory.product.PizzaCaliVegan;

public class PizzeriaCaliAF extends PizzeriaZonaAF {

    @Override
    protected PizzaProducto crearPizza(String tipo) {
        PizzaProducto producto = null;


        switch (tipo) {
            case "vegan":
                producto = new PizzaCaliVegan();
                break;

        }
        return producto;
    }
}
