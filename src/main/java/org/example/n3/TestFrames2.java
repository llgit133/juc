package org.example.n3;

public class TestFrames2 {

    public static void main(String[] args) {

        //1、 t1调用method1
        Thread t1 = new Thread("t1"){
            @Override
            public void run() {
                method1(20);
            }
        };
        t1.start();

        //2、 main调用method1
        method1(10);
    }
    public static void method1(int x){
        int y = x + 1;
        Object m = method2();
        System.out.println(m);
    }
    public static Object method2(){
        Object n = new Object();
        return n;
    }
}
