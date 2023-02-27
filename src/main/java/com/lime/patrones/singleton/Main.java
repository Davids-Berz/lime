package com.lime.patrones.singleton;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            ConexionBdSingleton conexionBdSingleton = ConexionBdSingleton.getInstance();
            System.out.println("conexionBdSingleton = " + conexionBdSingleton);
            
        }
    }
}
