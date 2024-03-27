package org.atguigu.completableFuture.future.vantage;


import java.util.concurrent.*;

public class FutureThreadPoolDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long startTime = System.currentTimeMillis();
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        FutureTask<String> futureTask1 = new FutureTask<String>(() -> {
            try {TimeUnit.SECONDS.sleep(5);} catch (InterruptedException e) {e.printStackTrace();}
            return "task1 over";
        });
        threadPool.submit(futureTask1);

        FutureTask<String> futureTask2 = new FutureTask<String>(() -> {
            try {TimeUnit.SECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}
            return "task2 over";
        });

        threadPool.submit(futureTask2);

        try {TimeUnit.MICROSECONDS.sleep(3);} catch (InterruptedException e) {e.printStackTrace();}

        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
        long endTime = System.currentTimeMillis();
        System.out.println("相差的时间："+(endTime-startTime));
    }

    String totalTime(){

        try {
            TimeUnit.MICROSECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.MICROSECONDS.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }
}
