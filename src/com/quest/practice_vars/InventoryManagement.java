package com.quest.practice_vars;

import java.util.Scanner;

public class InventoryManagement {
    static String[] products;
    static int[][] inventory;
    static int[] quantitiesSold;
    static int numberOfProducts;
    static int shortage;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        numberOfProducts = getValidInt(scanner);

        products = new String[numberOfProducts];
        inventory = new int[numberOfProducts][2];   //[quantity,price]
        quantitiesSold = new int[numberOfProducts];

        //get input from user
        getInputFromUser(scanner);

        //generate sales report
        System.out.println("\nTask 1: Sales Report:");
        generateSalesReport();

        //inventory shortage check
        System.out.println("\nTask 2: Inventory Shortage Check:");
        checkInventoryShortage();

        //Restock inventory
        System.out.println("\nTask 3: Restock Inventory:");
        System.out.println("Enter product index to restock (0-" + (numberOfProducts - 1) + "): ");
        int productIndex = scanner.nextInt();
        System.out.println("Enter restock amount: ");
        int restockAmount = getValidInt(scanner);
        restockInventory(productIndex, restockAmount);

        //generate sales summary
        System.out.println("\nTask 4: Sales Summary Based on Price Range:");
        System.out.print("Enter minimum price: ");
        double minimumPrice = scanner.nextInt();
        System.out.print("Enter maximum price: ");
        double maximumPrice = scanner.nextInt();
        generateSalesSummary(minimumPrice, maximumPrice);

        //retrieve out of stock
        System.out.println("\nTask 5: Out of stock Products:");
        checkOutOfStock();

    }

    //method to get input from user
    private static void getInputFromUser(Scanner scanner) {
        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println("Enter details for Product " + (i + 1) + ":");

            System.out.print("Product Name: ");
            products[i] = scanner.nextLine();

            System.out.print("Enter initial stock: ");
            inventory[i][0] = getValidInt(scanner);

            System.out.print("Enter price per unit: ");
            inventory[i][1] = getValidInt(scanner);

            System.out.print("Enter quantity sold: ");
            quantitiesSold[i] = getValidInt(scanner);
        }
    }

    //method to generate sales report
    private static void generateSalesReport() {
        double totalRevenue = 0;
        for (int i = 0; i < products.length; i++) {
            int stock = inventory[i][0];
            int price = inventory[i][1];
            int quantitySold = Math.min(quantitiesSold[i], stock); // Handle stock shortage
            double revenue = quantitySold * price;
            System.out.println(products[i] + " sold " + quantitySold + " units, Revenue: " + revenue);
            totalRevenue += revenue;
        }
        System.out.println("Total Revenue: " + totalRevenue);
    }

    //method to check shortage
    private static void checkInventoryShortage() {
        for (int i = 0; i < products.length; i++) {
            int stock = inventory[i][0];
            int quantitySold = quantitiesSold[i];
            if (quantitySold > stock) {
                shortage = quantitySold - stock;
                System.out.println("Warning, Insufficient stock for " + products[i] + "Sold " + quantitySold + " units, but only " + stock + " units were available");
            }
        }
    }

    //method to restock product
    private static void restockInventory(int productIndex, int restockAmount) {
        if (productIndex < 0 || productIndex >= products.length) {
            System.out.println("Invalid product index.");
            return;
        }
        restockAmount-=shortage;
        inventory[productIndex][0] += restockAmount;
        System.out.println("Updated stock for " + products[productIndex] + ":" + inventory[productIndex][0] + " units");
    }

    //method to generate sales summary
    private static void generateSalesSummary(double minimumPrice, double maximumPrice) {
        System.out.println("Products in the price range " + minimumPrice + " to " + maximumPrice);
        boolean found = false;
        for (int i = 0; i < products.length; i++) {
            int price = inventory[i][1];
            int stock = inventory[i][0];
            int quantitySoled = Math.min(quantitiesSold[i], stock);
            double revenue = quantitySoled * price;
            if (price >= minimumPrice && price <= maximumPrice) {
                found = true;
                System.out.println(products[i] + ": Revenue: " + revenue);
            }
        }
        if (!found) {
            System.out.println("No product found in the range");
        }
    }

    //method to find out of stock
    private static void checkOutOfStock() {
        boolean outOfStock = false;
        for (int i = 0; i < products.length; i++) {
            int stock = inventory[i][0];
            if (stock == 0) {
                outOfStock = true;
                System.out.println("Product " + products[i] + " is out of stock");
            }
        }
        if (!outOfStock) {
            System.out.println("No products are out of stock");
        }
    }

    private static int getValidInt(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (number > 0) {
                    scanner.nextLine();
                    return number;
                } else {
                    System.out.print("Invalid input, please enter a positive number: ");
                }
            } else {
                System.out.print("Invalid input, please enter an integer: ");
                scanner.nextLine();
            }
        }
    }

}
