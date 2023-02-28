package com.lime.patrones.observer;

@FunctionalInterface
public interface Observer {

    void update(Observable observable);
}
