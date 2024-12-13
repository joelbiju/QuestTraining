package com.quest.case_study.product_inventory_management;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product(101, "Laptop", 1000, 2));
        products.add(new Product(102, "Keyboard", 70, 5));
        products.add(new Product(103, "Mouse", 50, 5));
        products.add(new Product(104, "Monitor", 300, 3));

        ProductOperations ops = new ProductOperations();

        System.out.println("Total inventory Value: "+ops.computeTotalPrice(products));

        System.out.println("Top 3 expensive Products: ");
        System.out.println(ops.mostExpensiveProducts(products));

        System.out.println("Product Map: ");
        System.out.println(ops.collectProductsToMap(products));

    }
}
