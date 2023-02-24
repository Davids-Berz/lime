package com.lime.hilos;

import com.lime.hilos.thread.NombreThread;

public class Hilos {

    public static void main(String[] args) throws InterruptedException {

        // Nuevo
        Thread hilo = new NombreThread("Hilo 1");
        System.out.println("despues de la instancia: " + hilo.getState());
        // En Ejecucion
        hilo.start();

        Thread hilo2 = new NombreThread("Hilo 2");
        hilo2.start();

        System.out.println("despues del start:  " + hilo.getState());
        Thread.sleep(100);

        // Determina el estado del ciclo de vida ()
        System.out.println("despues del sleep: " +hilo.getState());
    }
}
