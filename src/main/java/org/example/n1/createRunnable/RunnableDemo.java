package org.example.n1.createRunnable;

public class RunnableDemo {

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable, "1号线程");
        thread.start();

        for(int i = 0 ; i < 100 ; i++ ){
            System.out.println("main线程" + i);
        }
    }
}
