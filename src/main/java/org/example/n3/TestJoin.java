package org.example.n3;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j(topic = "c.TestJoin")
public class TestJoin {


    static int r = 0;
    private static void test1() throws InterruptedException {
        log.debug("开始");
        Thread t1 = new Thread(() -> {
            log.debug("开始");
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            log.debug("结束");
            r = 10;
        });
        t1.start();
        log.debug("结果为:{}", r);
        log.debug("结束");
    }

    static int r1 = 0;
    static int r2 = 0;

    private static void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            r1 = 10;
        });
        Thread t2 = new Thread(() -> {
            try {
                sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            r2 = 20;
        });
        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        log.debug("join start");
        t2.join();
        log.debug("t2 join end");
        t1.join();
        log.debug("t1 join eng");
        long end = System.currentTimeMillis();
        log.debug("r1: {} r2: {} cost: {}", r1, r2, end - start);
    }
    public static void test3() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            r1 = 10;
        });
        long start = System.currentTimeMillis();
        t1.start();
        // 线程执行结束会导致 join 结束
        log.debug("join begin");
        t1.join(3000);
        long end = System.currentTimeMillis();
        log.debug("r1: {} r2: {} cost: {}", r1, r2, end - start);
    }
    public static void main(String[] args) throws InterruptedException {
        test3();
    }
}
