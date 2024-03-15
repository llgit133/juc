package org.example.n1.createThread;

public class ThreadDemo {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        for(int i = 0 ; i < 100 ; i++ ){
            System.out.println("main线程" + i);
        }
        // 建议线程先创建子线程，主线程的任务放在之后，否则主线程（main）永远是先执行完

    }
}
