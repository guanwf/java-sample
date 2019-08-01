package com.github.java.demo.synchronizeddemo;

public class VolatileDemo {

    static class Thread01 implements Runnable{

        private volatile int value=0;

        @Override
        public synchronized void run() {
            value=value+10;
            System.out.println(Thread.currentThread()+","+Thread.currentThread().getName()+",value="+value);
        }

    }

    public static void main(String[] args){

        Thread01 thread01=new Thread01();

        //1
        Thread t1=new Thread(thread01,"1");
        t1.start();

//        try {
//            Thread.sleep(1000L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        //2
        Thread t2=new Thread(thread01,"2");
        t2.start();
        Thread t3=new Thread(thread01,"3");
        t3.start();

    }

}
