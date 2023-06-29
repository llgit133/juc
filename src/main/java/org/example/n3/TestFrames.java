package org.example.n3;

public class TestFrames {


    public static void main(String[] args) {
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
