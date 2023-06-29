package org.example.test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test1 {

    public static void main(String[] args) {

        // 构造方法的参数是给线程指定名字，推荐
        Thread t1 = new Thread("t1") {
            @Override
            // run 方法内实现了要执行的任务
            public void run() {
                log.error("thread running");
            }
        };

        t1.start();
        log.error("running");
    }
}
