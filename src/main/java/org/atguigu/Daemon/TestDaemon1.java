package org.atguigu.Daemon;

import java.util.concurrent.TimeUnit;

public class TestDaemon1 {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 开始运行,"
                    + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));
            while (true){

            }
        }, "t1");


        t1.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 开始运行,"
                + "main线程");
    }

}
