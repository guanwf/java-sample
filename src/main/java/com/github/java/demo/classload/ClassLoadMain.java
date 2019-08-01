package com.github.java.demo.classload;

public class ClassLoadMain {

    public static void main(String[] args) {

        try {
            Class<?> classLoadTest=Class.forName("com.github.java.demo.classload.ClassLoadTest");
            classLoadTest.getName();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
