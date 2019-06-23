package com.github.java.demo.executorservice;

import java.text.MessageFormat;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<PCData> queue;

    private static final int SLEEPTIME=1000;

    public Consumer(BlockingQueue<PCData> queue){
        this.queue=queue;
    }

    public void run(){
        System.out.println("static Consumer id="+Thread.currentThread().getId());
        try{
            while (true){
                PCData data=queue.take();
                if (null!=data){
                    int re=data.getData() * data.getData();
                    System.out.println(MessageFormat.format("{0} * {1} = {2}  线程={3}",data.getData(),data.getData(),re,Thread.currentThread().getId()));
                }

                //
                if(Thread.currentThread().getId()==11){
                    //模式线程11暂停
                    System.out.println("暂停------线程------"+Thread.currentThread().getId());
                    Thread.sleep(5 * 1000);
                }
            }
        }catch (InterruptedException ex){
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

}
