package org.atguigu.basic.java8;


import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

// 函数式编程
public class funcDemo {

    public static void main(String[] args) {


        // Lambda 表达式
        // Stream 流式调用

        //Runnable  Function  Consumer  BiConsumer  Supplier

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };


        Function function = new Function() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        };


        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {

            }
        };

        BiConsumer biConsumer = new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {

            }
        };


        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                return null;
            }
        };


    }
}
