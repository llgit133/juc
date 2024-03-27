package org.atguigu.completableFuture.fun;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//对计算结果进行处理

// 1.thenApply 上步的运算结果传递到下一步    由于存在依赖关系（当前步错，不走下一步），当前步骤有异常的话就叫停 f->
// 2.handle  区别在于对异常的处理  (f,e)->
public class CompletableFutureFun2 {


  public static void main(String[] args) throws InterruptedException {


    testfuture3();
    System.out.println(Thread.currentThread().getName() + "------主线程先去做其他事情");
  }


  static void testfuture1(){
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
      try{TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();}
      return 1;
    },executorService).thenApply(f ->{
      System.out.println("222");
      return 2;
    }).handle((f,e)->{
      System.out.println("3333");
      int i=10/0;
      return f + 2;
    }).whenComplete((v, e) -> {
      if (e == null) {
        System.out.println("----计算结果" + v);
      }
    }).exceptionally(e -> {
      e.printStackTrace();
      System.out.println(e.getCause());
      return null;
    });
    executorService.shutdown();
  }



  static void testfuture2(){
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    // 拆分 串行化
    CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
      try{TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();}
      System.out.println("1111");
      return 1;
    },executorService);

    CompletableFuture<Integer> future2 = future1.thenApply(f -> {
      System.out.println("2222");
      // int i = 10 / 0;      // 异常会停止
      return f + 2;
    });

    CompletableFuture<Integer> future3 = future2.thenApply(f -> {
      System.out.println("3333");
      return f + 3;
    });

    CompletableFuture<Integer> future4 = future3.whenComplete((v, e) -> {
      if (e == null) {
        System.out.println("----计算结果" + v);
      }
    });

    future4.exceptionally(e->{
      e.printStackTrace();
      System.out.println(e.getCause());
      return null;
    });
    executorService.shutdown();
  }



  static void testfuture3(){
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    // 拆分 串行化
    CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
      try{TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();}
      System.out.println("1111");
      return 1;
    },executorService);

    CompletableFuture<Integer> future2 = future1.handle((f,e)-> {
      System.out.println("2222");
      int i = 10 / 0;
      return f + 2;
    });

    CompletableFuture<Integer> future3 = future2.handle((f,e) -> {
      System.out.println("3333");
      return f + 3;
    });

    CompletableFuture<Integer> future4 = future3.whenComplete((v, e) -> {
      if (e == null) {
        System.out.println("----计算结果" + v);
      }
    });

    future4.exceptionally(e->{
      e.printStackTrace();
      System.out.println(e.getCause());
      return null;
    });
    executorService.shutdown();
  }
}
