package com.lime.poo.herencia;

public class AlumnoExterno extends Alumno {

    public AlumnoExterno() {
        System.out.println("inicia constructor AlumnoExterno");
    }

    private String pais;
    private double Idiomas;

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getIdiomas() {
        return Idiomas;
    }

    public void setIdiomas(double idiomas) {
        Idiomas = idiomas;
    }
}
