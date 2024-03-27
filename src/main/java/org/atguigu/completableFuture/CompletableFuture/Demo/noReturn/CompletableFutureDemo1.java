package org.atguigu.completableFuture.completableFuture.demo.noReturn;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

// 无返回值 不传线程池
public class CompletableFutureDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName());   // 不传线程池 默认是ForkJoinPool.commonPool
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

        System.out.println(completableFuture.get()); // null
    }
}


