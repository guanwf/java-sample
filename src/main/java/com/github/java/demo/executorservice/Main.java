package com.github.java.demo.executorservice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;


public class Main {

    public static void main(String[] args) throws InterruptedException{

        BlockingQueue<PCData> queue=new LinkedBlockingDeque<PCData>(10);

        Producer producer1=new Producer(queue);
        Consumer consumer1=new Consumer(queue);

        ExecutorService service= Executors.newCachedThreadPool();

        service.execute(producer1);
        Thread.sleep(3 * 1000);

        service.execute(consumer1);
        service.execute(consumer1);
        service.execute(consumer1);

        //service.execute(consumer1);

        Thread.sleep(10 * 1000);

        producer1.stop();

        Thread.sleep(3000);
        service.shutdown();
        System.out.println("final.");

    }
}
