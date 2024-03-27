package org.atguigu.completableFuture.completableFuture.demo.noReturn;

import java.util.concurrent.*;

public class CompletableFutureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());   // 传线程池 是executorService 自定义的线程池
            try{TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();}
        },executorService);

        System.out.println(completableFuture.get());
        executorService.shutdown();

    }
}
