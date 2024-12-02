package com.quest.collections.exercise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContainsElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        System.out.println("Enter set 1 elements: ");
        String str1 = sc.nextLine();
        System.out.println("Enter set 2 elements: ");
        String str2 = sc.nextLine();

        String[] strArr = str1.split(" ");
        String[] strArr2 = str2.split(" ");

        for (int i = 0; i < strArr.length; i++) {
            set1.add(Integer.parseInt(strArr[i]));
        }
        for (int i = 0; i < strArr2.length; i++) {
            set2.add(Integer.parseInt(strArr2[i]));
        }

        if (set1.containsAll(set2)) {
            System.out.println("Set 1 contains " + set2);
        } else {
            System.out.println("Set 1 does not contain " + set2);
        }
    }
}
