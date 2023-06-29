package org.example.test;


import lombok.extern.slf4j.Slf4j;

import java.io.FileReader;

@Slf4j(topic = "c.Test4")
public class Test4 {
    public static void main(String[] args) {
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                log.debug("running1 ");
            }
        };
        t1.run();


        Thread t2 = new Thread("t2"){
            @Override
            public void run() {
                log.debug("running2 ");
            }
        };
        t2.start();
    }
}
