package com.lime.hilos.timer;

import java.awt.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class AgendaTareaTimerPeriod {

    public static void main(String[] args) {
        Timer timer = new Timer();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        AtomicInteger contador = new AtomicInteger(3);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                int i = contador.getAndDecrement();
                if (i > 0) {
                    toolkit.beep();
                    System.out.println("Tarea periodica en " + new Date() + " nombre del Thread:"
                            + Thread.currentThread().getName());
                } else {
                    System.out.println("finaliza el tiempo");
                    timer.cancel();
                }

            }
        }, 0, 3000);

        System.out.println("Agedamos tarea despues de 5 seg ...");
    }
}
