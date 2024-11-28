package com.quest.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Workout {
    public static void main(String[] args) {
        Map<Character, String> map = new HashMap<>();
        map.put('A', "Apple");
        map.put('D', "Dolphin");
        map.put('B', "Banana");
        map.put('E', "Elephant");
        map.put('C', "Cheese");

        Map<Integer, Double> map2 = new HashMap<>();
        map2.put(1, 3.576);
        map2.put(4, 6.789);
        map2.put(2, 4.0654);
        map2.put(5, 7.456);
        map2.put(3, 5.345);

        HashMap<Character, String> hashMap1 = new HashMap<>(map);
        TreeMap<Character, String> treeMap1 = new TreeMap<>(map);

        System.out.println("HashMap contents: ");
        hashMap1.forEach((v,c)-> System.out.println(v+" "+c));
        System.out.println("TreeMap contents: ");
        treeMap1.forEach((v,c)->System.out.println(v+" "+c));

        HashMap<Integer, Double> hashMap2 = new HashMap<>(map2);
        TreeMap<Integer, Double> treeMap2 = new TreeMap<>(map2);

        System.out.println("TreeMap contents: ");
        treeMap2.forEach((v,c)->System.out.println(v+" "+c));
        System.out.println("HashMap contents: ");
        hashMap2.forEach((v,c)->System.out.println(v+" "+c));

    }
}
