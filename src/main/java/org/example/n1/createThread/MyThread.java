package org.example.n1.createThread;

public class MyThread  extends Thread{

    @Override
    public void run() {
        for(int i = 0 ; i < 100 ; i++ ) {
            System.out.println("子线程输出："+i);
        }
    }
}
