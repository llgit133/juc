package org.atguigu.completableFuture.CompletableFuture.Demo.hasReturn;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CompletableFutureDemo3 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try{TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();}
            return "hello supplyAsync";
        });

        System.out.println(completableFuture.get());
    }
}
