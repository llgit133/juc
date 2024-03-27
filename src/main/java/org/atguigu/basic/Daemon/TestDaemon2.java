package org.atguigu.basic.Daemon;

import java.util.concurrent.TimeUnit;

public class TestDaemon2 {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 开始运行,"
                    + (Thread.currentThread().isDaemon() ? "守护线程" : "用户线程"));

            while (true){

            }
        }, "t1");

        // 把t1 守护线程
        t1.setDaemon(true);
        t1.start();


        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 开始运行," + "main线程");

        //守护线程会伴随着JVM一同结束工作，即使还有循环没有结束
        //所以假如当系统只剩下守护线程的时候，守护线程伴随着JVM一同结束工作。
    }
}
