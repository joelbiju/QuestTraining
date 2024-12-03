
//Create a program that identifies the first duplicate number in a sequence of integers using a Set.
package com.quest.collections.exercise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateNumbers {
    public static void main(String[] args) {
        Set<Integer> numberSet = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        String input = sc.nextLine();
        String[] numbers = input.split(" ");
        int[] numberArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numberArray[i] = Integer.parseInt(numbers[i]);
        }

        int flag =0;
        for (int i = 0; i < numbers.length; i++) {
            if (numberSet.contains(numberArray[i])) {
                System.out.println("Duplicate number: " + numberArray[i]);
                flag = 1;
                break;
            } else {
                numberSet.add(numberArray[i]);
            }
        }
        if (flag == 0) {
            System.out.println("No duplicate numbers");
        }
    }
}
