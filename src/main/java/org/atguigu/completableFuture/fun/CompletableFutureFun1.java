package org.atguigu.completableFuture.fun;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


//获得结果和触发计算
public class CompletableFutureFun1 {

  public static void main(String[] args)
      throws ExecutionException, InterruptedException, TimeoutException {

    CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
      try{TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();}
      return "hello supplyAsync";
    });

    // System.out.println(completableFuture.get());  // throws ExecutionException, InterruptedException
    // System.out.println(completableFuture.get(2L,TimeUnit.SECONDS));
    // System.out.println(completableFuture.join()); // 无throws Execution


    // 4.getNow
    // 现在就要，但是计算还有 3S 才计算完成
    // 计算完成就返回正常值，否则返回备胎值（传入的参数），立即获取结果不阻塞
    // try{TimeUnit.SECONDS.sleep(3);}catch (Exception e){e.printStackTrace();}
    // System.out.println(completableFuture.getNow("XXX"));


    //5.是否打断get方法立即返回括号值 completableFuture.join() completableFuture.get()
    // sleep 1,3 未成功打断false    sleep 3，1 成功打断true
    try{TimeUnit.SECONDS.sleep(1);}catch (Exception e){e.printStackTrace();}
    System.out.println(completableFuture.complete("completeValue" + "\t" + completableFuture.join()));

  }
}
