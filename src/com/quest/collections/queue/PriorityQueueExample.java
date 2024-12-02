package com.quest.collections.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(7);
        pq.add(1);
        pq.add(9);
        pq.add(3);
        pq.add(5);
        System.out.println("pq: "+pq);
        System.out.println("pq.peek(): "+pq.peek());
        System.out.println("pq.poll(): "+pq.poll());

        PriorityQueue<Character> pq2 = new PriorityQueue<>();
        pq2.add('A');
        pq2.add('C');
        pq2.add('E');
        pq2.add('B');
        pq2.add('D');
        System.out.println("\npq: "+pq2);
        System.out.println("pq.peek(): "+pq2.peek());
        System.out.println("pq.poll(): "+pq2.poll());

        PriorityQueue<String> pq3 = new PriorityQueue<>();
        pq3.add("Apple");
        pq3.add("Cherry");
        pq3.add("Grape");
        pq3.add("Banana");

        System.out.println("\npq: "+pq3);
        System.out.println("pq.peek(): "+pq3.peek());
        System.out.println("pq.poll(): "+pq3.poll());

        PriorityQueue<Double> pq4 = new PriorityQueue<>();
        pq4.add(5.0);
        pq4.add(3.0);
        pq4.add(6.44);
        pq4.add(7.5);
        pq4.add(3.85);

        System.out.println("\npq: "+pq4);
        System.out.println("pq.peek(): "+pq4.peek());
        System.out.println("pq.poll(): "+pq4.poll());

    }
}
