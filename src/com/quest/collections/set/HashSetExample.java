package com.quest.collections.set;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(5);
        System.out.println(set.size());
        System.out.println(set);
        System.out.println(set.remove(2));
        System.out.println(set);
        System.out.println(set.isEmpty());
        System.out.println(set.contains(3));

        /*for (int i : set) {
            System.out.println(i);
        }

        System.out.println("Array list: ");
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(5);
        for (int i : list) {
            System.out.println(i);
        }*/
    }
}
