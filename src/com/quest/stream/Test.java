package com.quest.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);

        System.out.println(list.stream().findFirst());
        System.out.println("findAny: " + list.stream().findAny());
        System.out.println("max: " + list.stream().max(Integer::compareTo).get());

        Optional<Integer> min = list.stream().min(Integer::compareTo);
        System.out.println("min: " + min.get());

        System.out.println("count: " + list.stream().count());
        System.out.println("distinct: " + list.stream().distinct().count());
        System.out.println("sum: " + list.stream().reduce(0, Integer::sum));

        List<Integer> list2 = list.stream().filter(i -> i % 2 == 0).toList();
        System.out.println("list2: " + list2);

        List<Integer> list3 = list.stream().map(i -> i * 2).toList();
        System.out.println("list3: " + list3);

        int x = list.stream().map(integer -> integer * 2).max(Integer::compareTo).get();
        int y = list.stream().map(integer -> integer * 2).min(Integer::compareTo).get();
        System.out.println("max x: " + x + " min y: " + y);

    }
}
