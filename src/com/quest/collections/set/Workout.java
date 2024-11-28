package com.quest.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Workout {
    public static void main(String[] args) {

        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 1; i < 15; i++) {
            set1.add(i);
        }

        System.out.println("\nPrinting the HashSet: ");
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
        System.out.println("\nPrinting the LinkedHashSet: ");
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

        int[] elements = {42,3,5,77,92,55,12,14};
        HashSet<Integer> set3 = new HashSet<>();
        LinkedHashSet<Integer> set4 = new LinkedHashSet<>();
        TreeSet<Integer> set5 = new TreeSet<>();
        for (int i : elements) {
            set3.add(i);
            set4.add(i);
            set5.add(i);
        }

        System.out.println("\nHashSet elements: "+set3);
        System.out.println("LinkedHashSet elements: "+set4);
        System.out.println("TreeSet elements: "+set5);
    }
}
