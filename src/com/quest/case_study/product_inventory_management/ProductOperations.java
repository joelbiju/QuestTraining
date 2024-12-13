package com.quest.case_study.product_inventory_management;

import java.util.*;
import java.util.stream.Collectors;

public class ProductOperations {

    public double computeTotalPrice(List<Product> products) {
        return products.stream().mapToDouble(product-> product.getPrice()*product.getQuantity()).sum();
    }

    public List<Product> mostExpensiveProducts(List<Product> products) {
        return products.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).limit(3).toList();
    }

    public Map<String, Double> collectProductsToMap(List<Product> products) {
        Map<String, Double> productsMap = new HashMap<>();

        products.forEach(product -> productsMap.put(product.getName(), product.getPrice()));
        return productsMap;
    }
}
