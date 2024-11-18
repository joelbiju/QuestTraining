package com.quest.exam;

import java.util.Scanner;

public class AnalysisManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //stock details
        System.out.println("Enter the details for Equity Stock: ");
        System.out.print("Stock Name: ");
        String eqStockName = getValidString(sc);
        System.out.print("Stock Symbol: ");
        String eqStockSymbol = getValidString(sc);
        System.out.print("Sector: ");
        String eqSector = getValidString(sc);
        System.out.print("Number of days: ");
        int eqDays = getValidInt(sc);
        int[] eqPrices = new int[eqDays];
        System.out.print("Enter prices: ");
        for (int i = 0; i < eqDays; i++) {
            eqPrices[i] = getValidInt(sc);
        }
        EquityStockAnalyzer equityStock = new EquityStockAnalyzer(eqStockName, eqStockSymbol, eqSector, eqPrices);

        sc.nextLine();
        //commodity details
        System.out.println("Enter details for Commodity Stock:");
        System.out.print("Commodity Type: ");
        String comType = getValidString(sc);
        String comName = comType;
        System.out.print("Stock Symbol: ");
        String comSymbol = getValidString(sc);
        System.out.print("Number of days: ");
        int comDays = getValidInt(sc);
        int[] comPrices = new int[comDays];
        System.out.print("Enter prices: ");
        for (int i = 0; i < comDays; i++) {
            comPrices[i] = getValidInt(sc);
        }
        CommodityStockAnalyzer commodityStock = new CommodityStockAnalyzer(comName, comSymbol, comPrices, comType);

        //display analysis
        System.out.println();
        equityStock.displayAnalysis();
        System.out.println();
        commodityStock.displayAnalysis();
    }

    public static String getValidString(Scanner sc) {
        while (true) {
            String input = sc.nextLine();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Please enter a valid stock name");
            }
        }
    }

    public static int getValidInt(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Invalid input, please enter a positive number");
                }
            } else {
                System.out.println("Please enter a valid number");
            }
        }
    }
}
