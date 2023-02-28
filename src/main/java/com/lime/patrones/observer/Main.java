package com.lime.patrones.observer;

public class Main {
    public static void main(String[] args) {

        // ejemplo de observable
        Corporacion google = new Corporacion("Google", 1000);
        google.addObserver(observable -> {
            System.out.println("John: " + ((Corporacion) observable).getNombre()
                    + " Nuevo precio: "+
                    + ((Corporacion) observable).getPrecio());
        });

        google.addObserver(observable -> {
            System.out.println("Andres: " + ((Corporacion) observable).getNombre()
                    + " Nuevo precio: "+
                    + ((Corporacion) observable).getPrecio());
        });

        google.addObserver(observable -> {
            System.out.println("Jose: " + ((Corporacion) observable).getNombre()
                    + " Nuevo precio: "+
                    + ((Corporacion) observable).getPrecio());
        });

        google.modificaPrecio(2000);


    }
}
