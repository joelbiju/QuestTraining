package com.quest.practice_vars;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = sc.nextInt();
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        System.out.println("The sum is: " + sum);
    }
}
