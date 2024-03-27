package org.designPattern;

import org.designPattern.strategy.SortService;
import org.designPattern.strategy.impl.BubbleSortStrategy;
import org.designPattern.strategy.impl.QuickSortStrategy;

public class StrategyPatternTest {

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{2,4,6,3,1,7,9,8};
        SortService sortService1 = new SortService(new BubbleSortStrategy());
        sortService1.sort(arr);

        System.out.println("=========================================");


        SortService sortService2 = new SortService(new QuickSortStrategy());
        sortService2.sort(arr);

        System.out.println("=========================================");

    }
}
