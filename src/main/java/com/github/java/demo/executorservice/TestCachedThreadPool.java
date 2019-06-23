package com.github.java.demo.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCachedThreadPool {

    public static void main(String[] args) {
//                ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
//         ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            TestCachedThreadPool.TestRunnable demo=new TestCachedThreadPool().new TestRunnable();
            executorService.execute(demo);
            System.out.println("************* a" + i + " *************");
        }
        executorService.shutdown();

    }

    class TestRunnable implements Runnable {

        private boolean isRunning=true;

        public void run() {
            System.out.println(Thread.currentThread().getName() + "线程被调用了。");
            while (isRunning) {
                try {
                    Thread.sleep(5000);
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void  stop(){
            isRunning=false;
        }
    }

}