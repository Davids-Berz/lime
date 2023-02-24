package com.lime.hilos.thread;

import java.util.Arrays;
import java.util.List;

public class NombreThread extends Thread {


    public NombreThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Se inicia el metodo run del hilo " + getName());

        Arrays.asList(1,2,3,4,5,6,7,8,9,10).forEach(System.out::println);
        System.out.println("finaliza hilo");
    }
}
