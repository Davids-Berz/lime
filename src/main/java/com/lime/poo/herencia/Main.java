package com.lime.poo.herencia;

public class Main {

    public static void main(String[] args) {

        Persona alumno = new Alumno();
        alumno.setNombre("David");
        System.out.println("alumno = " + alumno);
        System.out.println();

        Persona profesor = new Profesor();
        ((Profesor)profesor).setAsignatura("Matematicas");
        System.out.println("profesor = " + profesor);
        System.out.println();

        Persona alumnoExterno = new AlumnoExterno();
        ((AlumnoExterno)alumnoExterno).setIdiomas(8.9);
        System.out.println("alumnoExterno = " + alumnoExterno);

        System.out.println();

        Class clase = new AlumnoExterno().getClass();
        while (clase.getSuperclass() != null) {
            String hija = clase.getSimpleName();
            String padre = clase.getSuperclass().getSimpleName();
            System.out.println(hija + " es una clase hija de la clase padre " + padre);
            clase = clase.getSuperclass();
        }
    }
}
