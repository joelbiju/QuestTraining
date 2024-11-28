package com.quest.collections.map;

import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String,String> map = new TreeMap<>();
        map.put("John", "Wick");
        map.put("Mad", "Max");
        map.put("Tom", "Cruise");
        map.put("Luke","Cage");
        map.put("Jessica","Jones");
        map.forEach((k,v)-> System.out.println(k+" "+v));
        map.replace("Mad","Max","Alex");
        map.forEach((k,v)-> System.out.println(k+" "+v));


    }
}
