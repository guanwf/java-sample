package com.github.java.demo.executorservice;

import java.util.HashSet;

public class HashSetDemo {

    public static HashSet<Long> queueHashSet = new HashSet<Long>();

    public static void main(String[] args) throws InterruptedException {

        queueHashSet.add(1L);
        queueHashSet.add(2L);
        queueHashSet.add(3L);

        if (queueHashSet.contains(1L)) {
            System.out.println("true");
        }

        queueHashSet.remove(1L);

        if (queueHashSet.contains(1L)) {
            System.out.println("true");
        }

        System.out.println(queueHashSet.size());

    }

}
