package org.designPattern.strategy.impl;

import org.designPattern.strategy.SortStrategy;

import java.util.Arrays;

public class QuickSortStrategy implements SortStrategy {
    @Override
    public void sort(Integer[] arr) {
        Arrays.sort(arr);
        System.out.println("QuickSortStrategy: "+Arrays.asList(arr));
    }
}
