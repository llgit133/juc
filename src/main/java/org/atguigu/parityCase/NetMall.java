package org.atguigu.parityCase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class NetMall {
    private String netMallName;

    public double calcPrice(String productName) {
        try {TimeUnit.SECONDS.sleep(1);} catch (InterruptedException e) {e.printStackTrace();}
        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}
