package com.github.java.demo.synchronizeddemo;

public class ThreadVolatile extends Thread {

    private volatile int value=0;

    private ThreadVolatileTest threadVolatileTest;

    public ThreadVolatile(ThreadVolatileTest threadVolatileTest){
        this.threadVolatileTest=threadVolatileTest;
    }

    @Override
    public void run(){
//        value=value+10;
//        System.out.println(Thread.currentThread()+","+Thread.currentThread().getName()+",value="+value);

        threadVolatileTest.setValue(10);
        System.out.println(Thread.currentThread()+","+Thread.currentThread().getName()+",value="+threadVolatileTest.getValue());
    }

}
