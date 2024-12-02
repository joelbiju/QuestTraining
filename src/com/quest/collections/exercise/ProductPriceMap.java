package com.quest.collections.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProductPriceMap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Double> productPriceMap = new HashMap<String, Double>();

        productPriceMap.put("Apple", 1.5);
        productPriceMap.put("Banana", 0.75);
        productPriceMap.put("Orange", 1.2);
        productPriceMap.put("Grape", 2.0);
        productPriceMap.put("Pineapple", 3.5);

        // Display the Map of products and prices
        System.out.println("Product Prices: " + productPriceMap);

        // Update the price of a product
        productPriceMap.put("Banana", 0.80);
        productPriceMap.put("Grape", 2.2);

        System.out.println("\nUpdated Product Prices: " + productPriceMap);

        double maxPrice = 0.0;
        String maxPriceProduct = null;

        for (Map.Entry<String, Double> entry : productPriceMap.entrySet()) {
            if (entry.getValue() > maxPrice) {
                maxPrice = entry.getValue();
                maxPriceProduct = entry.getKey();
            }
        }

        System.out.println("\nProduct with the highest price: " + maxPriceProduct + " - $" + maxPrice);
    }
}
