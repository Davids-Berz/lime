package com.lime.patrones.composite;

import java.util.ArrayList;
import java.util.List;

public class Directorio extends Componente {


    public Directorio(String nombre) {
        super(nombre);
        this.hijos = new ArrayList<>();
    }

    private List<Componente> hijos;

    public Directorio addComponente(Componente c) {
        hijos.add(c);
        return this;
    }

    @Override
    public boolean buscar(String nombre) {
        if (this.nombre.equalsIgnoreCase(nombre))
            return true;
        for (Componente hijo : hijos) {
            if (hijo.buscar(nombre))
                return true;
        }
        return false;
    }

    public void remove(Componente c) {
        hijos.remove(c);
    }

    @Override
    public String mostrar(int nivel) {
        StringBuilder print = new StringBuilder("\t".repeat(nivel));
        print
                .append(nombre)
                .append("/")
                .append("\n");
        for (Componente hijo : hijos) {
            print
                    .append(hijo.mostrar(nivel + 1));
            if (hijo instanceof Archivo)
                print.append("\n");
        }

        return print.toString();
    }
}
