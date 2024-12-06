package com.quest.consumers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class NumberProcessor {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        List<Integer> transformList = new ArrayList<>();

        Predicate<Integer> evenNumbers = (number) -> number % 2 == 0;

        Consumer<List<Integer>> multiplyNumber = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) * 2);
            }
        };

        Supplier<List<Integer>> transformedList = () -> numbers;
    }
}
