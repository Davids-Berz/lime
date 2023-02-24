package com.lime.hilos.sincronizacion;

import com.lime.hilos.runnable.ImprimirFrases;


public class EjemploSincronizacionThread {

    public static void main(String[] args) throws InterruptedException {

        new Thread(new ImprimirFrases("Hola ", "Que tal")).start();
        new Thread(new ImprimirFrases("Quien eres ", "Tu?")).start();
        new Thread(new ImprimirFrases("muchas ", "gracias")).start();

        Thread.sleep(100);
        Thread h4 = new Thread(new ImprimirFrases("Hasta ", "Luego"));
        h4.start();
        Thread.sleep(100);
        System.out.println("thread h4 " + h4.getState());

    }

    public synchronized static void imprimirFrases(String frase1, String frase2) {
        System.out.print(frase1);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(frase2);
    }

}
