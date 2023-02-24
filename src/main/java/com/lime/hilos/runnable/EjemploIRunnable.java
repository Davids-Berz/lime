package com.lime.hilos.runnable;

public class EjemploIRunnable {

    public static void main(String[] args) throws InterruptedException {

        Thread main = Thread.currentThread();

        /*new Thread(new ViajeTarea("USA")).start();
        new Thread(new ViajeTarea("Canada")).start();
        new Thread(new ViajeTarea("Chile")).start();
        new Thread(new ViajeTarea("Argentina")).start();*/

        // join
        Thread v1 =new Thread(new ViajeTarea("Europa"));
        Thread v2 =new Thread(new ViajeTarea("Asia"));
        Thread v3 =new Thread(new ViajeTarea("America"));
        Thread v4 =new Thread(new ViajeTarea("Africa"));

        v1.start();
        v2.start();
        v3.start();
        v4.start();

        v1.join();
        v2.join();
        v3.join();
        v4.join();

        System.out.println("Continua con la ejecucion del main: " +  main.getName());
        System.out.println("main " + main.getState());

    }
}
