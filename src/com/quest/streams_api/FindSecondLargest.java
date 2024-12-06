package com.quest.streams_api;

import java.util.*;
import java.util.stream.Stream;

public class FindSecondLargest {
    public static void main(String[] args) {

        Stream<Integer> list = Stream.of(101,11,20,33,55,80,12);

        Optional<Integer> secondHighest = list.distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(secondHighest.get());
    }
}
