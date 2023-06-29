package org.example.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j(topic = "c.Test3")
public class Test3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建任务对象
//        FutureTask<Integer> task3 = new FutureTask<>(() -> {
//            log.debug("hello");
//            return 100;
//        });

        FutureTask<Integer> task3 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

                log.debug("running");
                Thread.sleep(1000);
                return 100;
            }
        });

        // 参数1 是任务对象; 参数2 是线程名字，推荐
        new Thread(task3, "t3").start();

        // 主线程阻塞，同步等待 task 执行完毕的结果
        Integer result = task3.get();
        log.debug("结果是:{}", result);
    }
}
