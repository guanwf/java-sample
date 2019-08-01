package com.github.java.demo.synchronizeddemo;

import java.util.ArrayList;
import java.util.List;

public class BlockQueue {
    private List list=new ArrayList();

    public synchronized Object pop() throws InterruptedException{
        while(list.size()==0){
//        if (list.size()==0){
            System.out.println(Thread.currentThread()+">>wait");
            this.wait();
        }
        if (list.size()>0){
            System.out.println(">>size"+this.list.size());
            return list.remove(0);
        }
        else{
            System.out.println(">>size=0");
            return null;
        }
    }

    public synchronized void put(Object o){
        System.out.println("put"+o.toString());
        this.list.add(o);
        this.notify();
    }

    public static void main(String[] args) throws InterruptedException {
        BlockQueue blockQueue=new BlockQueue();

        //1
        new Thread(){
            @Override
            public void run() {
                try {
                    blockQueue.pop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }.start();

        Thread.sleep(2000L);

        //2
        new Thread(){
            @Override
            public void run() {
                blockQueue.put("abc");
            }
        }.start();

        Thread.sleep(1000L);

    }

}
