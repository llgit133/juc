package org.atguigu.completableFuture.parityCase;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

// 电商网站比价的案例
// step by step
public class CompletableFutureMallDemo1 {

    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("tao bao"),
            new NetMall("dang dang"));

    public static List<String> getPrice(List<NetMall> list, String productName) {
        //《Mysql》 in jd price is 88.05 流式计算
        // 把参数 NetMall 入参数遍历，转为 String

        //List<NetMall> --> List<String>
        return list.stream().map(netMall ->
                String.format("《" + productName + "》" + "in %s price is %.2f",
                                netMall.getNetMallName(),
                                netMall.calcPrice(productName)))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        long l = System.currentTimeMillis();
        List<String> mysql_list = getPrice(list, "mysql");
        for (String string : mysql_list) {
            System.out.println(string);
        }

        long l1 = System.currentTimeMillis();
        System.out.println("cost time 耗时："+(l1-l)); //cost time 耗时：3072
    }
}



@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
class NetMall {
    private String netMallName;

    public double calcPrice(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}

