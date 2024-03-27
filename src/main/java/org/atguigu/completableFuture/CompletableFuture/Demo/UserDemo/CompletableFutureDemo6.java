package org.atguigu.completableFuture.completableFuture.demo.userDemo;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// 测试 CompletionStage 有顺序的执行
// 异步调用链 实现异步任务编排 有些任务依赖于其他任务执行结束
public class CompletableFutureDemo6 {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture.supplyAsync(() -> {

            return null;
        },executorService);


        executorService.shutdown();


    }
}
