package com.lime.hilos.sync.runnable;

import com.lime.hilos.sync.Panaderia;

public class Main {

    public static void main(String[] args) {

        Panaderia p = new Panaderia();

        new Thread(new Panadero(p)).start();
        new Thread(new Consumidor(p)).start();
    }
}
