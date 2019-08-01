package com.github.java.demo.synchronizeddemo;

public class Mutex {

    private final static Object LOCK=new Object();
    private int index=0;

    public void accessToken() {
        try {
            synchronized (LOCK){
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName()+",index="+this.index++);
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        final Mutex mutex=new Mutex();

        for(int i=0;i<5;i++){
            new Thread(mutex::accessToken,"线程"+i).start();
        }
    }
}
