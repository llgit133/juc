package org.example.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.Test2")
public class Test2 {
    public static void main(String[] args) {

//        Runnable runnable = new Runnable(){
//            @Override
//            public void run() {
//                log.error("runnable running");
//            }
//        };

        Runnable runnable = () -> log.debug("runnable running");

        Thread t = new Thread(runnable,"t2");
        t.start();

        log.debug("running");
    }
}
