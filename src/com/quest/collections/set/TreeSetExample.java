package com.quest.collections.set;

import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(1);
        ts.add(3);
        ts.add(2);
        ts.add(5);
        for (Integer i : ts){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(ts.first());
        System.out.println(ts.last());
        System.out.println(ts);
        System.out.println(ts.descendingSet());
        System.out.println(ts);
    }
}
