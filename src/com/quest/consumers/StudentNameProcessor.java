package com.quest.consumers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class StudentNameProcessor {
    public static void main(String[] args) {
        List<String> studentNames = new ArrayList<>(Arrays.asList("John", "Steve", "Spector"));
        studentNames.add("Max");
        studentNames.add("Jim");
        studentNames.add("Stuart");
        studentNames.add("Nick");

        Consumer<String> printUpperCase = (name) -> System.out.println(name.toUpperCase());
        Consumer<String> printLength = (name) -> System.out.println("Length: " + name.length());

        Predicate<String> checkLength = (name) -> name.length() <= 5;

        Supplier<String> messageSupplier = () ->{
            for (String name : studentNames) {
                if (name.length() > 6) {
                    return name + " is too long";
                }
            }
            return "All names are short";
        };

        for (String name : studentNames) {
            printUpperCase.accept(name);
            printLength.accept(name);
            if (checkLength.test(name)) {
                System.out.println(name+" -> under 5 letters");
            }
        }
        System.out.println();
        System.out.println(messageSupplier.get());
    }
}
