package com.lime.poo.abstracta;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<? extends Number> lista = new ArrayList<>();
        lista.add(); // Error de compilación, no se puede añadir un entero a una lista de números.
        Number numero = lista.get(0);
    }
}
