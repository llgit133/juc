package org.example.test;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

@Slf4j(topic = "c.Test12")
public class Test12 {

    private static void test2() throws InterruptedException {
        Thread t2 = new Thread(()->{
            while(true) {
                boolean interrupted = Thread.currentThread().isInterrupted();
                if(interrupted) {
                    log.debug(" 被打断了，退出循环: {}", interrupted);
                    break;
                }
            }
        }, "t2");
        t2.start();
        sleep(10);
        log.debug("interrupt");
        t2.interrupt();
    }

    public static void main(String[] args) throws InterruptedException {
        test2();
    }
}
