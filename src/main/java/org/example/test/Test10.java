package org.example.test;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test10")
public class Test10 {

    static int r = 0;

    private static void test1() throws InterruptedException {
        log.debug("开始");
        Thread t1 = new Thread(() -> {
            log.debug("开始");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("结束");
            r = 10;
        });

        t1.start();
        t1.join();
        log.debug("结果为:{}", r);
        log.debug("结束");
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

}

