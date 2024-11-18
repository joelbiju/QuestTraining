package com.quest.exam;

public class EquityStockAnalyzer extends StockAnalyzer {
    String sector;

    public EquityStockAnalyzer(String stockName, String stockSymbol, String sector, int[] price) {
        super(stockName, stockSymbol, price);
        this.sector = sector;
    }

    @Override
    public int findMaxPrice() {
        int max = price[0];
        for (int i = 1; i < price.length; i++) {
            if (price[i] > max) {
                max = price[i];
            }
        }
        return max;
    }

    @Override
    public int findMinPrice() {
        int min = price[0];
        for (int i = 1; i < price.length; i++) {
            if (price[i] < min) {
                min = price[i];
            }
        }
        return min;
    }

    @Override
    public double calculateAveragePrice() {
        double sum = 0;
        for (int j : price) {
            sum += j;
        }
        return (sum / price.length);
    }

    @Override
    public int[] findLongestIncreasingTrend() {
        int maxLength = 0;
        int startIndex = 0;
        int length = 1;
        int currentStart = 0;

        for (int i = 1; i < price.length; i++) {
            if (price[i] > price[i - 1]) {
                length++;
            } else {
                length = 1;
                currentStart = i;
            }
            if (length > maxLength) {
                maxLength = length;
                startIndex = currentStart;
            }
        }
        int[] result = {startIndex + 1, startIndex + maxLength, maxLength};
        return result;
    }

    @Override
    public void displayAnalysis() {
        System.out.println("Analysis for Equity Stock:");
        System.out.println("Stock Name:" + stockName);
        System.out.println("Stock Symbol:" + stockSymbol);
        System.out.println("Sector:" + sector);
        System.out.println("Highest Price:" + findMaxPrice());
        System.out.println("Lowest Price:" + findMinPrice());
        System.out.println("Average Price:" + calculateAveragePrice());
        int[] trend = findLongestIncreasingTrend();
        System.out.println("Longest Increasing Trend: Start Day " + trend[0] + ", End Day " + trend[1] + ", Length " + trend[2] + " days");
    }
}
