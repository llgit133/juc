package org.example.test;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j(topic = "c.Test11")
public class Test11 {

    private static void test1() throws InterruptedException {

        Thread t1 = new Thread(()->{
            log.debug("sleep....");
            try {
                sleep(2000);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }, "t1");
        t1.start();

        sleep(1000);  //主线程等等，不然t1还没睡，就打印了
        log.debug("t1 interrupt");
        t1.interrupt();
        log.debug(" 打断状态: {}", t1.isInterrupted());
    }

    public static void main(String[] args) throws InterruptedException {
        test1();
    }
}
