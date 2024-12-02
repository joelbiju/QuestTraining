package com.quest.collections.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SortMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("banana", 3);
        map.put("apple", 5);
        map.put("orange", 2);
        map.put("grape", 4);
        System.out.println("Original Map: " + map);

        Map<String, Integer> sortedMap = new TreeMap<>(map);
        System.out.println("Sorted Map: " + sortedMap);
    }
}
