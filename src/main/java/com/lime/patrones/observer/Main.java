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

        // ejemplo usuario
        System.out.println("\n");
        Usuario usuario = new Usuario();

        usuario.addObserver(o -> System.out.println("Enviando email a usuario"));
        usuario.addObserver(o -> System.out.println("Enviando email a Administrador"));
        usuario.addObserver(o -> System.out.println("Guardando info de usuario"));
        usuario.crearUsuario("David");




    }
}
