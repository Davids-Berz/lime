package com.lime.hilos.sync.runnable;

import com.lime.hilos.sync.Panaderia;

import java.util.concurrent.ThreadLocalRandom;

public class Consumidor implements Runnable{

    public Consumidor(Panaderia panaderia) {
        this.panaderia = panaderia;
    }

    private Panaderia panaderia;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                panaderia.consumir();
                Thread.sleep(ThreadLocalRandom.current().nextInt(500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
