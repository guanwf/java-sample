package com.github.java.completablefuture;

import java.lang.reflect.Proxy;
import java.util.concurrent.*;

public class FutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Integer> future = executorService.submit(() -> {
            try {
                System.out.println("please wait...");
                Thread.sleep(2000);
                System.out.println("please wait.ok");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            return 789;
        });

        System.out.println(future.get());
        System.out.println("done!");

    }

}
