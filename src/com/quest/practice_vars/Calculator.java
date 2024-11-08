package com.quest.practice_vars;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the starting number: ");
        double start = sc.nextInt();
        boolean continueCalculation = true;
        System.out.println("Current result:" + start);
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Square Root");
        System.out.println("6. Clear current result");
        System.out.println("7. Exit");
        while (continueCalculation) {
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the number to add: ");
                    int add = sc.nextInt();
                    start += add;
                    System.out.println("Current result: " + start);
                    break;
                }
                case 2: {
                    System.out.println("Enter the number to subtract: ");
                    int sub = sc.nextInt();
                    start -= sub;
                    System.out.println("Current result: " + start);
                    break;
                }
                case 3: {
                    System.out.println("Enter the number to multiply: ");
                    int multi = sc.nextInt();
                    start *= multi;
                    System.out.println("Current result: " + start);
                    break;
                }
                case 4: {
                    System.out.println("Enter the number to divide: ");
                    int div = sc.nextInt();
                    if (div == 0) {
                        System.out.println("Cannot divide by zero");
                        break;
                    }
                    start /= div;
                    System.out.println("Current result: " + start);
                    break;
                }
                case 5: {
                    if (start < 0) {
                        System.out.println("Cannot square root of negative number");
                        break;
                    }
                    start = Math.sqrt(start);
                    System.out.println("Current result: " + start);
                    break;
                }
                case 6: {
                    System.out.println("Enter the number to clear current result: ");
                    start = 0;
                    System.out.println("Current result: " + start);
                    break;
                }
                case 7: {
                    System.out.println("Exiting Calculator");
                    continueCalculation = false;
                    break;
                }
                default: {
                    System.out.println("Invalid choice");
                    break;
                }
            }
            System.out.println("Continue calculation? (yes/no): ");
            if (sc.next().equalsIgnoreCase("yes")) {
                continueCalculation = true;
            } else {
                continueCalculation = false;
            }
        }

    }
}
