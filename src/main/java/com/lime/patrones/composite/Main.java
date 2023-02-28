package com.lime.patrones.composite;

public class Main {

    public static void main(String[] args) {

        Directorio doc = new Directorio("Documentos");
        Directorio java = new Directorio("Java");

        java.addComponente(new Archivo("patron-composite.docx"));

        Directorio stream = new Directorio("Api Stream");
        stream.addComponente(new Archivo("stream-map.docx"));

        java.addComponente(stream);

        doc.addComponente(java);
        doc.addComponente(new Archivo("CV.docx"));
        doc.addComponente(new Archivo("logo.jpg"));

        boolean encontrado = doc.buscar("documentos");

        System.out.println("encontrado = " + encontrado);
        
        System.out.println(doc.mostrar(0));

    }
}
