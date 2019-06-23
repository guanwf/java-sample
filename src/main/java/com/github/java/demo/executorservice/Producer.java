package com.github.java.demo.executorservice;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<PCData> queue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEPTTIME = 1000;

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    public void run() {
        PCData data = null;
        Random r = new Random();
        System.out.println("start producer is = " + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(r.nextInt(SLEEPTTIME));
                data = new PCData(count.incrementAndGet());
                System.out.println(data + " is put into queue，线程=" + Thread.currentThread().getId());
                if (!queue.offer(data, 2, TimeUnit.SECONDS)) {//插入队列中
                    System.out.println(" failed to put data：" + data);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }

    public void stop() {
        isRunning = false;
    }
}
