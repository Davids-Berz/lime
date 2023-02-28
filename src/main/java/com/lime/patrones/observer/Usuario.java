package com.lime.patrones.observer;


import java.util.ArrayList;
import java.util.List;

public class Usuario extends Observable{

    private List<String> repos = new ArrayList<>();

    public void crearUsuario(String usuario) {
        repos.add(usuario);
        notifyObservers();
    }
}
