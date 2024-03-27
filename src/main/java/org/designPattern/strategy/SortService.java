package org.designPattern.strategy;

public class SortService {

    private SortStrategy strategy;

    public SortStrategy getStrategy() {
        return strategy;
    }

    public SortService(SortStrategy strategy) {
        this.strategy = strategy;
    }


    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(Integer[] arr){
        strategy.sort(arr);
    }

}
