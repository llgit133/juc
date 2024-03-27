package org.liao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
    public static void main(String[] args) {

        String fileSize = String.valueOf("825.00").toString();
        fileSize = fileSize.split("\\.")[0];
        System.out.println(fileSize);







        // 创建一个线程池来执行任务
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // 提交任务到线程池
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                // 生成一个介于1到99999之间的随机整数
                int sequence = ThreadLocalRandom.current().nextInt(10000, 100000);
                System.out.println(Thread.currentThread().getName() + "生成的序列号是：" + sequence);
            });
        }

        // 关闭线程池
        executorService.shutdown();
    }
}






