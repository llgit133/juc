package org.atguigu.completableFuture.fun;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureFun3 {

  public static void main(String[] args) {

//    testfuture1();
    testThenRun();
    testThenAccept();
    testThenApply();
    System.out.println(Thread.currentThread().getName() + "------主线程先去做其他事情");
  }


  static void testfuture1(){
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
      return 1;
    }, executorService);

    CompletableFuture<Integer> future2 = future1.thenApply(f -> {
      return f + 2;
    });

    CompletableFuture<Integer> future3 = future2.thenApply(f -> {
      return f + 3;
    });

    CompletableFuture<Void> completableFuture = future3.thenAccept(r->{
      System.out.println(r);
    });
    executorService.shutdown();
  }


  static void testThenRun(){

    CompletableFuture<Integer> futureA = CompletableFuture.supplyAsync(() -> {
      return 1;
    });
    CompletableFuture<Void> futureB = futureA.thenRun(() -> {
    });

    //任务A执行完执行B，并且不需要A的结果
    System.out.println("testThenRun:"+futureB.join()); //  null
  }

  static void testThenAccept(){
    CompletableFuture<Integer> futureA = CompletableFuture.supplyAsync(() -> {
      return 1;
    });
    CompletableFuture<Void> futureB = futureA.thenAccept( f-> {
    });

    //任务A执行完执行B，B需要A的结果，但是任务B没有返回值
    System.out.println("testThenAccept:"+futureB.join()); // null
  }


  static void testThenApply(){
    CompletableFuture<Integer> futureA = CompletableFuture.supplyAsync(() -> {
      return 1;
    });
    CompletableFuture<Integer> futureB = futureA.thenApply( f-> {
      return f + 2;
    });

    //任务A执行完执行B，B需要A的结果，同时任务B有返回值
    System.out.println("testThenApply:"+futureB.join()); // 3
  }
}
