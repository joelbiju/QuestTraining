package com.quest.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Workout {
    public static void main(String[] args) {

        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 1; i < 15; i++) {
            set1.add(i);
        }
        System.out.println("\nPrinting using Iterator");
        Iterator<Integer> iterator = set1.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        set1.add(23);
        set1.add(20);
        set1.add(null);
        System.out.println("\nPrinting after adding random elements: ");
        System.out.println(set1);

        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
        for (int i = 1; i < 15; i+=2) {
            set2.add(i);
        }
        System.out.println("\nPrinting using LinkedHashSet: ");
        Iterator<Integer> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            System.out.print(iterator2.next() + " ");
        }

        System.out.println();
        set2.add(23);
        set2.add(20);
        set2.add(null);
        System.out.println("\nPrinting after adding random elements: ");
        System.out.println(set2);
    }
}
