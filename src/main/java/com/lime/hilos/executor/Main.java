package com.lime.hilos.executor;

import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Callable<String> tarea = () -> {
            System.out.println("inicio de la tarea");
            try {
                System.out.println("Nombre del thread: " + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            System.out.println("finaliza la tarea");
            return "- Algo";
        };

        Future<String> resultado = executorService.submit(tarea);

        while (!resultado.isDone()) {
            System.out.println("ejecutando tarea");
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("Tarea " + resultado.get());

//        executorService.execute(tarea);
        executorService.shutdown();
        System.out.println("Continuando con la ejecucion del main 1");
        executorService.awaitTermination(2, TimeUnit.SECONDS);
        System.out.println("Continuando con la ejecucion del main 2");
    }
}
