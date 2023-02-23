package com.lime.poo.abstracta;

public class Main {

    public static void main(String[] args) {

        Circulo circulo = new Circulo(10);

        Figura cuadrado = new Figura() {
            @Override
            public void log() {
                System.out.println("cuadrado " + calcularArea());
            }

            @Override
            public double calcularArea() {
                return 14*14;
            }
        };

        circulo.log();
        cuadrado.log();
    }
}
