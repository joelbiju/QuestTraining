package com.quest.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> lh = new LinkedHashMap<>();
        lh.put(1, "Mango");
        lh.put(2, "Pineapple");
        lh.put(3, "Watermelon");
        lh.put(4, "Apple");
        lh.put(5, "Orange");

        for (int i: lh.keySet()) {
            System.out.println(i);
        }
        for (String s: lh.values()) {
            System.out.println(s);
        }
        System.out.println(lh);

        for (Map.Entry<Integer,String> en: lh.entrySet()) {
            System.out.println(en.getKey()+" "+en.getValue());
        }

        lh.replace(3,"Grape");
        System.out.println(lh);

        lh.remove(5);
        System.out.println(lh);

        lh.forEach((key, value)->System.out.println(key+" "+value));

    }
}
