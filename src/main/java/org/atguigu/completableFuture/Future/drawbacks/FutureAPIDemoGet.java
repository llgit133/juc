package org.atguigu.completableFuture.Future.drawbacks;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureAPIDemoGet {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        FutureTask<String> futureTask = new FutureTask<String>(()->{

            System.out.println(Thread.currentThread().getName()+"---->");
            try{
                TimeUnit.SECONDS.sleep(3);
            }catch (Exception e){
                e.printStackTrace();
            }
            return "task over";

        });

        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println(Thread.currentThread().getName()+"忙其他任务了");


        //get()阻塞---一旦调用get()方法求结果，一旦调用不见不散，非要等到结果才会离开，不管你是否计算完成，如果没有计算完成容易程序堵塞
        System.out.println(futureTask.get());
    }
}
