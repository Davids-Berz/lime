package com.lime.patrones.singleton;

public class ConexionBdSingleton {

    public ConexionBdSingleton() {
        System.out.println("Conectandose a una base de datos");
    }

    private static ConexionBdSingleton instancia;

    public static ConexionBdSingleton getInstance() {
        if (instancia == null) {
            instancia = new ConexionBdSingleton();
        }
        return instancia;
    }

}
