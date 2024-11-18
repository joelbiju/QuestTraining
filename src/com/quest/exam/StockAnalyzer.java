package com.quest.exam;

public abstract class StockAnalyzer {
    String stockName;
    String stockSymbol;
    int[] price;

    public StockAnalyzer(String stockName, String stockSymbol, int[] price) {
        this.stockName = stockName;
        this.stockSymbol = stockSymbol;
        this.price = price;
    }

    public abstract int findMaxPrice();
    public abstract int findMinPrice();
    public abstract double calculateAveragePrice();
    public abstract int[] findLongestIncreasingTrend();
    public abstract void displayAnalysis();
}
