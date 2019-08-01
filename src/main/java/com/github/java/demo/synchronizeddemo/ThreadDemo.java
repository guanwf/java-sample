package com.github.java.demo.synchronizeddemo;

import java.util.concurrent.BlockingQueue;

public class ThreadDemo {

    public static void main(String[] args){
        //1
        new Thread(){

            @Override
            public void run() {
                System.out.println(Thread.currentThread());
            }

        }.start();

        //2
        new ThreadDemo.Thread2().start();
    }

    static class Thread2 extends Thread{

        @Override
        public void run() {
            System.out.println(">>"+Thread.currentThread());
        }
    }
}
