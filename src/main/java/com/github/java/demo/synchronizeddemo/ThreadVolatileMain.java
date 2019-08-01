package com.github.java.demo.synchronizeddemo;

public class ThreadVolatileMain {

    public static void main(String[] args) {

        ThreadVolatileTest threadVolatileTest=new ThreadVolatileTest();

        ThreadVolatile thread01 = new ThreadVolatile(threadVolatileTest);
        thread01.start();

        ThreadVolatile thread03 = new ThreadVolatile(threadVolatileTest);
        thread03.start();

//        ThreadVolatile2 thread02 = new ThreadVolatile2(threadVolatileTest);
//        thread02.start();

    }
}
