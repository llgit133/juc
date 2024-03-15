package org.example.n1.createCallable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) {
        Callable call = new MyCallable();
        FutureTask<String> task = new FutureTask<>(call);
        Thread t = new Thread(task);
        t.start();
        try {
            String s = task.get(); // 获取call方法返回的结果（正常/异常结果）
            System.out.println("获取call方法返回的结果:"+s);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        for(int i = 0 ; i < 100 ; i++ ){
            System.out.println("main线程" + i);
        }

    }

}
