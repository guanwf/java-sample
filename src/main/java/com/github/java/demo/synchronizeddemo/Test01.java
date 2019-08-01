package com.github.java.demo.synchronizeddemo;

public class Test01 implements Runnable {

    private final static Object METUX = new Object();
    private final int MAX = 200;
    int index = 1;

    public static void main(String[] args) {

        final Test01 test01 = new Test01();

        Thread thread1 = new Thread(test01, "线程1");
        Thread thread2 = new Thread(test01, "线程2");
        Thread thread3 = new Thread(test01, "线程3");

        thread1.start();
        thread2.start();
        thread3.start();

    }

    @Override
    public void run() {

//        synchronized (METUX)
        {
            while (index <= this.MAX) {
                try {
                    System.out.println(Thread.currentThread()+Thread.currentThread().getName() + ",index=" + index++);
                    Thread.sleep(1000L);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

}
