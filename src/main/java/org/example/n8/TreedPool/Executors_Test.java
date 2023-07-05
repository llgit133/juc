package org.example.n8.TreedPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executors_Test {

    public static void main(String[] args) {

        ExecutorService service1 = Executors.newFixedThreadPool(2);   //直接创建一个固定容量的线程池
        ExecutorService service2 = Executors.newSingleThreadExecutor();
        ExecutorService service3 = Executors.newCachedThreadPool();

    }
}
