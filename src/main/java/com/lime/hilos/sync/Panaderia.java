package com.lime.hilos.sync;

public class Panaderia {

    private String pan;
    private boolean disp = false;

    public synchronized void hornear(String masa) throws InterruptedException {
        while (disp) {
            wait();
        }
        this.pan = masa;
        System.out.println("Panadero hornea pan " + this.pan);
        this.disp = true;
        notify();
    }

    public synchronized String consumir() throws InterruptedException {
        while (!disp) {
            wait();
        }
        System.out.println("cliente compra el pan " + this.pan);
        this.disp = false;
        notify();
        return this.pan;
    }
}
