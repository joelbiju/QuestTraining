package com.quest.collections.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        LinkedHashSet<String> set = new LinkedHashSet<>();

        set.add("A");
        set.add("C");
        set.add("B");
        set.add("D");

        System.out.println(set);
        System.out.println(set.contains("A"));
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.remove("B"));
        System.out.println(set);
        Iterator<String>iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(" "+iterator.next());
        }
    }
}
