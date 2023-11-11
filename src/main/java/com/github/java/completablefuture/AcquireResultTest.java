package com.github.java.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AcquireResultTest {

    //getNow方法测试

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> cp1 = CompletableFuture.supplyAsync(() -> {
            try {
//                Thread.sleep(60 * 1000 * 60);
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hello world";
        });

        //get()和get(long timeout, TimeUnit unit) => 在Future中就已经提供了，后者提供超时处理，如果在指定时间内未获取结果将抛出超时异常
        System.out.println("get()="+cp1.get());

        //getNow()立即获取结果不阻塞，结果计算已完成将返回结果或计算过程中的异常，如果未计算完成将返回设定的valueIfAbsent值
        System.out.println(cp1.getNow("hello h2t"));

        //join方法测试
        //join => 方法里不会抛出异常
//        CompletableFuture<Integer> cp2 = CompletableFuture.supplyAsync((() -> 1 / 0));
//        System.out.println(cp2.join());

        //get方法测试
        CompletableFuture<Integer> cp3 = CompletableFuture.supplyAsync((() -> 1 / 0));
        System.out.println(cp3.get());

    }

}
