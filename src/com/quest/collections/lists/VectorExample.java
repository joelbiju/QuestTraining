package com.quest.collections.lists;

import java.util.Vector;

public class VectorExample {
    public static void main(String[] args) {
        Vector<Integer> v = new Vector<Integer>();
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        System.out.println(v.get(2));
        System.out.println(v.size());
        System.out.println(v);
        System.out.println(v.contains(3));
        System.out.println(v.lastElement());
        System.out.println(v.firstElement());
        System.out.println(v.remove(1));
        System.out.println(v);
    }
}
