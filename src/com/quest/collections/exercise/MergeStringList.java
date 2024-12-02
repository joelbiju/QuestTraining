package com.quest.collections.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeStringList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> mergeList = new ArrayList<>();

        System.out.println("Enter list 1 elements: ");
        String str1 = sc.nextLine();
        System.out.println("Enter list 2 elements: ");
        String str2 = sc.nextLine();

        String[] arr1 = str1.split(" ");
        String[] arr2 = str2.split(" ");
        list1.addAll(Arrays.asList(arr1));
        list2.addAll(Arrays.asList(arr2));

        for (String s1 : list1) {
            mergeList.add(s1);
        }

        for (String s2 : list2) {
            if (!mergeList.contains(s2)) {
                mergeList.add(s2);
            }
        }

        System.out.println("Merged list elements: ");
        System.out.println(mergeList);
    }
}
