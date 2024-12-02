package com.quest.collections.exercise;

import java.util.*;

public class SecondLargestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        System.out.println("Enter numbers: ");
        String input = sc.nextLine();
        String[] numbers = input.split(" ");
        for (String number : numbers) {
            list.add(Integer.parseInt(number));
        }
        int max = list.get(0);
        int scMax = 0;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
            if (list.get(i) > scMax && list.get(i) != max) {
                scMax = list.get(i);
            }
        }
        System.out.println("Second largest element in list: " + scMax);

        /*Collections.sort(list, Collections.reverseOrder());
        int secondLargest = list.get(1);
        System.out.println("Second largest element in list: "+secondLargest);*/

    }
}
