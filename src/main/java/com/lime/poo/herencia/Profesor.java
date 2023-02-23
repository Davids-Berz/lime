package com.lime.poo.herencia;

public class Profesor extends Persona{

    public Profesor() {
        System.out.println("inicia constructor Profesor");
    }

    private String asignatura;

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
}
