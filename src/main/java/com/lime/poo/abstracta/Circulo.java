package com.lime.poo.abstracta;

public class Circulo extends Figura {

    public Circulo(double radio) {
        this.radio = radio;
    }

    private double radio;
    @Override
    public double calcularArea() {
        return Math.PI * (radio * radio);
    }

    @Override
    public void log() {
        System.out.println("circulo.calcularArea() = " + calcularArea());
    }

}
