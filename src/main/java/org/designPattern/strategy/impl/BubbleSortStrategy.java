package org.designPattern.strategy.impl;

import org.designPattern.strategy.SortStrategy;

import java.util.Arrays;

public class BubbleSortStrategy implements SortStrategy {
    @Override
    public void sort(Integer[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length-1 -i ; j++) {
                if(arr[j] > arr[j+1]){
                    Integer temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("BubbleSortStrategy: "+ Arrays.asList(arr));
    }
}
