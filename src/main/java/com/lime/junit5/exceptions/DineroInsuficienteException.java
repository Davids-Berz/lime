package com.lime.junit5.exceptions;

public class DineroInsuficienteException extends RuntimeException{
    public DineroInsuficienteException(String message) {
        super("Dinero insuficiente");
    }
}
