//Write a program to sort a Map<String, Integer> by its keys.
package com.quest.collections.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SortMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("lion", 3);
        map.put("elephant", 5);
        map.put("zebra", 2);
        map.put("giraffe", 4);
        System.out.println("Original Map: " + map);

        Map<String, Integer> sortedMap = new TreeMap<>(map);
        System.out.println("Sorted Map: " + sortedMap);
    }
}
