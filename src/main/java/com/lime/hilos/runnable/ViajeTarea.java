package com.lime.hilos.runnable;

public class ViajeTarea implements Runnable{

    public ViajeTarea(String nombre) {
        this.nombre = nombre;
    }
    private String nombre;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + nombre);
            /*try {
                Thread.sleep((long) (Math.random() + 1000));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }*/
        }
        System.out.println("Viaje a: " + nombre);
    }

    public String getNombre() {
        return nombre;
    }
}
