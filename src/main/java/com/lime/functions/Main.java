package com.lime.functions;

import com.lime.functions.entity.Usuario;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        
        Usuario usuario = instanciar("david", 24);


        System.out.println("usuario: nombre " + usuario.getNombre() + " edad " + usuario.getEdad());

    }
    
    static Usuario instanciar() {
        Supplier<Usuario> u = () -> new Usuario();
        return u.get();
    }

    static Usuario instanciar(String nombre, int edad) {
        Supplier<Usuario> u = () -> new Usuario(nombre, edad);
        return u.get();
    }
}
