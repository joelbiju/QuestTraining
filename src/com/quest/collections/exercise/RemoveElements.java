package com.quest.collections.exercise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveElements {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements: ");
        String str1 = sc.nextLine();

        String[] strArr = str1.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            set.add(Integer.parseInt(strArr[i]));
        }

        set.removeIf(num -> num % 3 == 0);

        System.out.println("Set after removing elements divisible by 3: "+set);
    }
}
