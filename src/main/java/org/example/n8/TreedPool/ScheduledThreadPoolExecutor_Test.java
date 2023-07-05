package org.example.n8.TreedPool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


// 定时任务
public class ScheduledThreadPoolExecutor_Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //直接设定核心线程数为1
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        //这里我们计划在3秒后执行
        executor.schedule(() -> System.out.println("HelloWorld!"), 3, TimeUnit.SECONDS);

        executor.shutdown();
    }
}
