package com.quest.collections.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        HashMap<Integer,String> h1 = new HashMap<>();
        h1.put(1,"Banana");
        h1.put(2,"Pineapple");
        h1.put(3,"Apple");
        h1.put(4,"Mango");
        h1.put(5,"Orange");
        for (String s: h1.values()){
            System.out.println(s);
        }
        for (Integer i : h1.keySet()){
            System.out.println(i);
        }
        System.out.println(h1.put(6,"Grape"));
        for (Map.Entry<Integer,String> e : h1.entrySet()){
            System.out.println(e.getKey()+" "+e.getValue());
        }
        System.out.println(h1.get(2));
        h1.remove(2);
    }
}
