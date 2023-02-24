package com.lime.hilos.executor;

import java.util.concurrent.*;

public class ExecutorServicePeriod {

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);

        System.out.println("Alguna tarea en el main");

        CountDownLatch lock = new CountDownLatch(5);

        Future<?> future = executorService.scheduleAtFixedRate(() -> {

            try {
                TimeUnit.SECONDS.sleep(1);
                lock.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Executor Service");
        }, 0, 2, TimeUnit.SECONDS);

        lock.await();
        future.cancel(true);
//        TimeUnit.SECONDS.sleep(10);
        System.out.println("Tarea despues de finalizar el executor");
        executorService.shutdown();
    }

}
