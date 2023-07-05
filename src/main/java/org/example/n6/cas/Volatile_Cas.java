package org.example.n6.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class Volatile_Cas {

    //为了保证该变量的可见性，需要使用 volatile 修饰。

    public static void main(String[] args) {

        // AtomicInteger 中的value是用volatile修饰的
        AtomicInteger  atomicInteger;
    }
}
