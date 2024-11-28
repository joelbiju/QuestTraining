package com.quest.collections.queue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        pq.add(4);
        pq.add(9);
        pq.add(2);
        pq.add(6);
        pq.add(3);
        pq.add(5);
        Iterator<Integer> it = pq.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("-----");
        pq.offer(11);
        pq.poll();  //pop first element
        pq.forEach(System.out::println);


    }
}
