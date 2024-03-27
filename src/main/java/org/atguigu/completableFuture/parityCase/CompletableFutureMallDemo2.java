package org.atguigu.completableFuture.parityCase;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

//all in
// 功能 -> 性能
public class CompletableFutureMallDemo2 {

  static List<NetMall> list = Arrays.asList(
      new NetMall("jd"),
      new NetMall("tao bao"),
      new NetMall("dang dang"),
      new NetMall("pdd"),
      new NetMall("tian mao"));


  public static List<String> getPriceByCompletableFuture(List<NetMall> list, String productName) {

    // List<NetMall> --> List < CompletableFuture<String> > --> List<String>
    ExecutorService executorService = Executors.newFixedThreadPool(3);

    return list.stream().map(netMall ->
            CompletableFuture.supplyAsync(() ->
                String.format("《" + productName + "》" + "in %s price is %.2f",
                    netMall.getNetMallName(),
                    netMall.calcPrice(productName))))     //Stream<CompletableFuture<String>>
        .collect(Collectors.toList())                                     //List<CompletableFuture<String>>
        .stream()                                                         //Stream<String>
        .map(s -> s.join()).collect(Collectors.toList());                 //List<String>


    // 线程手动shutdown     不加线程executorService  默认使用ForkJoinPool
  }


  public static void main(String[] args) {

    long l = System.currentTimeMillis();
    List<String> mysql_list = getPriceByCompletableFuture(list, "mysql");
    for (String string : mysql_list) {
      System.out.println(string);
    }
    long l1 = System.currentTimeMillis();
    System.out.println("cost time 耗时："+(l1-l)); //cost time 耗时：1057
  }
}


