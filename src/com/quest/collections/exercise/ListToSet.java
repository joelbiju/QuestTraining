
//Given a List<String> with duplicate elements, convert it to a Set to remove duplicates and print the result.
package com.quest.collections.exercise;
import java.util.*;

public class ListToSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        System.out.println("Enter the list elements: ");
        String str1 = sc.nextLine();

        String[] strArr = str1.split(" ");
        for (String str : strArr) {
            list.add(str);
        }

        Set<String> set = new HashSet<>(list);
        System.out.println("Set after removing duplicates: "+set);
    }
}
