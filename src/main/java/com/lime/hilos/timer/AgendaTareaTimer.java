package com.lime.hilos.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class AgendaTareaTimer {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Tarea realizada en " + new Date() + " nombre del Thread:"
                + Thread.currentThread().getName());
                System.out.println("finaliza el tiempo");
                timer.cancel();
            }
        }, 5000);

        System.out.println("Agedamos tarea despues de 5 seg ...");
    }
}
