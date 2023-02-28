package com.lime.patrones.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class PizzaProducto {

    public PizzaProducto() {
        ingredientes = new ArrayList<>();
    }

    protected String nombre;
    protected String masa;
    protected String salsa;
    protected List<String> ingredientes;

    public void preparar() {
        System.out.println("preparando la pizza");
        System.out.println("Seleccionando masa " + masa);
        System.out.println("Agregando salsa " + salsa);
        System.out.println("Agregando ingredientes: ");
        this.ingredientes.forEach(System.out::println);
    }

    abstract public void cocinar();

    abstract public void cortar();

    public void empaquetar() {
        System.out.println("Poniendo la pizza en caja");
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return new StringBuilder("\"Pizza\": {")
                .append("\n\t")
                .append("\"nombre\": " +"\""+ nombre+"\",")
                .append("\n\t")
                .append("\"masa\": "+"\"" + masa+"\",")
                .append("\n\t")
                .append("\"salsa\": "+"\"" + salsa+"\",")
                .append("\n\t")
                .append("\"ingredientes\": "+"\"" + ingredientes+"\"")
                .append("\n")
                .append("}").toString();
    }
}
