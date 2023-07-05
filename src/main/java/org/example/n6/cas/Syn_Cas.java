package org.example.n6.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class Syn_Cas {
    static Integer num  = 0;


    public static void Test1(){
        for (int i = 0; i < 3; i++) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (num < 1000){
                        System.out.println("thread name " +Thread.currentThread().getName()+" "+ num++);
                    }
                }
            });
            t1.start();
        }
    }


    // 悲观锁synchronized
    public static void Test2(){
        for (int i = 0; i < 3; i++) {
            Thread t2 = new Thread(new Runnable() {
                @Override
                public synchronized void run() {
                    while (num < 1000){
                        System.out.println("thread name " +Thread.currentThread().getName()+" "+ num++);
                    }
                }
            });
            t2.start();
        }
    }


    // 乐观锁cas
    static AtomicInteger num3 = new AtomicInteger(0);

    public static void Test3(){
        for (int i = 0; i < 3; i++) {
            Thread t3 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (num3.get() < 1000){
                        System.out.println("thread name " +Thread.currentThread().getName()+" "+ num3.incrementAndGet());
                    }
                }
            });
            t3.start();
        }
    }
    public static void main(String[] args) {
//
//        Test1();
//        Test2();
        Test3();
    }

}
