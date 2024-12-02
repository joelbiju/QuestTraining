package com.quest.collections.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountOccurrence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println("Enter numbers: ");
        String input = sc.nextLine();
        String[] numbers = input.split(" ");
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }
        boolean[] visited = new boolean[list.size()];

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                int count = 1;
                for (int j = i + 1; j < list.size(); j++) {
                    if (list.get(i).equals(list.get(j)) && !visited[j]) {
                        count++;
                        visited[j] = true;
                    }
                }
                System.out.println("Occurrence of " + list.get(i) + ": " + count);
            }

        }
    }
}
