
//Given a List of integers, remove all even numbers and print the updated list.

package com.quest.collections.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenOutList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the numbers with last value as '/': ");
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }
}
