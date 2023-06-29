package org.example.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j(topic = "c.Test6")
public class Test6 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        t1.start();
        log.debug("t1 state:{}",t1.getState());

//        Thread.sleep(500);
        TimeUnit.SECONDS.sleep(2);
        log.debug("t1 state:{}",t1.getState());
    }
}
