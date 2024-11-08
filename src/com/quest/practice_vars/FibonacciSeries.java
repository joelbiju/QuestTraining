package com.quest.practice_vars;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        int first=0;
        int second=1;
        System.out.println("Enter the number of elements:");
        n=sc.nextInt();
        if (n<0){
            System.out.println("Invalid input");
            return;
        }
        for (int i=1;i<=10;i++) {
            System.out.println(first+" ");
            int third=first+second;
            first=second;
            second=third;
        }
    }
}
