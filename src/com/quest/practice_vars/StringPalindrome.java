package com.quest.practice_vars;

import java.util.Scanner;

public class StringPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = sc.nextLine();
        if (s == null) {
            System.out.println("String is null");
            return;
        }
        s=s.toLowerCase();
        String reverse = new StringBuilder(s).reverse().toString();
        if (s.equals(reverse)) {
            System.out.println("It is a palindrome.");
        } else {
            System.out.println("It is not a palindrome.");
        }

    }
}
