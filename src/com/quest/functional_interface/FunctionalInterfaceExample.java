package com.quest.functional_interface;

import java.util.Optional;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {

        Supplier<Integer> randomNumberSupplier = () -> new Random().nextInt(100);

        Predicate<Integer> evenCheck = FunctionalInterfaceExample::isEven;

        Function<Integer, Integer> transformNumber = num -> evenCheck.test(num) ? num * num : num * 2;

        int number = randomNumberSupplier.get();
        System.out.println("Random number: " + number);
        Consumer<String> consumer = System.out::println;

        if (evenCheck.test(number)) {
            Optional<Integer> result = Optional.of(transformNumber.apply(number));
            result.ifPresentOrElse(
                    value -> consumer.accept("Result: " + value),
                    () -> consumer.accept("No result")
            );
        } else {
            Optional<Integer> result = Optional.empty();
            result.ifPresentOrElse(
                    value -> consumer.accept("Result: " + value),
                    () -> consumer.accept("No result")
            );
        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
