
//Write a program to find the union, intersection, and difference between two Set objects.
package com.quest.collections.exercise;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> unionSet = new HashSet<>();
        Set<Integer> intersectionSet = new HashSet<>();
        Set<Integer> differenceSet = new HashSet<>();

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

        unionSet.addAll(set1);
        unionSet.addAll(set2);
        System.out.println("Union of set1 and set2: " + unionSet);

        intersectionSet.addAll(set1);
        intersectionSet.retainAll(set2);
        System.out.println("Intersection of set1 and set2: " + intersectionSet);

        differenceSet.addAll(set1);
        differenceSet.removeAll(set2);
        System.out.println("Difference (set1 - set2): " + differenceSet);

    }
}
