package org.atguigu.parityCase;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 电商网站比价的案例
public class CompletableFutureMallDemo1 {

    static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("tao bao"),
            new NetMall("dang dang"));

    public static List<String> getPrice(List<NetMall> list, String productName) {
        //《Mysql》 in jd price is 88.05 流式计算
        // 把参数 NetMall 入参数遍历，转为 String
        return list.stream().map(netMall ->
                String.format("《" + productName + "》" + "in %s price is %.2f",
                                netMall.getNetMallName(),
                                netMall.calcPrice(productName)))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        getPrice(list,"mysql");
    }
}
