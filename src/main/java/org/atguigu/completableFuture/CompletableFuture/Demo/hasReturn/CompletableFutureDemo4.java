package org.atguigu.completableFuture.completableFuture.demo.hasReturn;

import java.util.concurrent.*;

public class CompletableFutureDemo4 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            try{
                TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();}
            return "hello supplyAsync";
        },executorService);

        System.out.println(completableFuture.get());
    }
}
