package org.atguigu.completableFuture.CompletableFuture.Demo.UserDemo;

import java.util.concurrent.*;

public class CompletableFutureDemo5 {

    public static void main(String[] args) {


        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            int result = ThreadLocalRandom.current().nextInt(10);
            try{TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();}
            if(result > 2){
                result  = result / 0;
            }
            return result;
        },executorService).whenComplete((v,e)->{
            // v 是返回值
            // e 是异常信息
            if(e == null){
                System.out.println("计算完成 更新系统的value："+v);
            }
        }).exceptionally(e->{
            System.out.println("异常信息打印：");
            e.printStackTrace();
            return null;
        });

        // 减少阻塞和轮询 whenComplete
        // 还可以打印异常信息 exceptionally，看到执行中的报错信息

        executorService.shutdown();
        System.out.println(Thread.currentThread().getName()+"去忙其他任务了");

    }
}
