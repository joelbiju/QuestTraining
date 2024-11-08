package com.quest.practice_vars;

import java.util.Scanner;

public class NumberPalindrome {
    public static void main(String[] args) {
        int reversedNumber=0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number to check palindrome: ");
        int number = sc.nextInt();
        int originalNumber = number;
        while (number!=0){
            int digit = number%10;
            reversedNumber=reversedNumber*10+digit;
            number/=10;
        }
        if(reversedNumber==originalNumber){
            System.out.println("It is Palindrome");
        }
        else{
            System.out.println("It is not Palindrome");
        }
    }
}
