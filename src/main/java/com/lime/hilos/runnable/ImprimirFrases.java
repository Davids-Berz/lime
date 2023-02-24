package com.lime.hilos.runnable;

import com.lime.hilos.sincronizacion.EjemploSincronizacionThread;

import java.util.ArrayList;
import java.util.List;

public class ImprimirFrases implements Runnable{

    String frase1, frase2;
    List<Integer> numeros;


    public ImprimirFrases(String frase1, String frase2) {
        this.frase1 = frase1;
        this.frase2 = frase2;
    }

    public ImprimirFrases() {
         numeros = new ArrayList<>();
    }

    @Override
    public void run() {
        EjemploSincronizacionThread.imprimirFrases(frase1, frase2);
    }

}
