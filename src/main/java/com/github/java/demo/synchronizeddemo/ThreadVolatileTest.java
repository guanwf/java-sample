package com.github.java.demo.synchronizeddemo;

public class ThreadVolatileTest {

    private int value = 0;

    public void setValue(int value){
        this.value+=value;
    }

    public int getValue(){
        return this.value;
    }

}
