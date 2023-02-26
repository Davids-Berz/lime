package com.lime.recursividad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Componente gabinetePc = new Componente("Gabinete PC");
        Componente fuente = new Componente("Fuente poder 700w");
        Componente placa = new Componente("MotherBoard");
        Componente gpu = new Componente("Nvidia GPU RXT");
        Componente ventilador = new Componente("Ventilador");
        Componente disipador = new Componente("Disipador");
        Componente tv = new Componente("Nvidia RTX 3060 8gb");
        Componente cpu = new Componente("AMD Ryzen 5");

        cpu.addComponent(ventilador)
                .addComponent(disipador);
        tv.addComponent(gpu);
        placa.addComponent(cpu)
                .addComponent(tv);
        gabinetePc.addComponent(fuente)
                .addComponent(placa)
                .addComponent(new Componente("Teclado"))
                .addComponent(new Componente("Mouse"));

        metodoRecursivo(gabinetePc, 0);

    }

    public static void metodoRecursivo(Componente c, int nivel) {
        System.out.println("\t".repeat(nivel) + c.getNombre());
        if (c.tieneHijos()) {
            for (Componente hijo : c.getHijos()) {
                metodoRecursivo(hijo, nivel++);
            }
        }
    }

}
