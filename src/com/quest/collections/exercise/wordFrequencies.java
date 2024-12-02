package com.quest.collections.exercise;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class wordFrequencies {
    public static void main (String[] args) {

        Map<String, Integer> wordCount = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String: ");
        String s = scanner.nextLine();
        String[] words = s.toLowerCase().split(" ");
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word,wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        System.out.println("Word Frequencies: ");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + "-> " + entry.getValue());
        }

    }
}
