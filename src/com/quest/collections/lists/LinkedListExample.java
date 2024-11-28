package com.quest.collections.lists;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Person> list = new LinkedList<Person>();

        list.add(new Person("john",22,"male","banglore"));
        list.add(new Person("matt",34,"male", "kochi"));
        list.add(new Person("jane", 24, "female", "banglore"));
        list.add(new Person("mary", 36, "female", "Delhi"));
        list.addFirst(new Person("henry",44, "male", "new york"));
        list.addLast(new Person("james",45,"male", "australia"));

        for (Person s : list) {
            System.out.println("Name: "+s.getName()+", Age: "+s.getAge());
        }
        System.out.println("\nfirst person: "+list.getFirst().getName());
        System.out.println("last person: "+list.getLast().getName());
        System.out.println("at index 4: "+list.get(4).getName());
        System.out.println("Size: "+list.size());

        System.out.println("\nAge filter > 30");
        for (Person s : list) {
            if(s.getAge()>30){
                System.out.println("Name: "+s.getName()+", Age: "+s.getAge());
            }
        }

        System.out.println("\nGender filter");
        for (Person s : list) {
            if (s.getGender().equalsIgnoreCase("male")){
                System.out.println(s.getName());
            }
        }

        System.out.println("\nremoved first and last person");
        list.removeFirst();
        list.removeLast();
        for (Person s : list) {
            System.out.println("Name: "+s.getName()+", Age: "+s.getAge());
        }
        System.out.println("Size after removal: "+list.size());

        System.out.println("\nRemoved person with name Mary");
        for (Person s : list) {
            if(s.getName().equalsIgnoreCase("mary")){
                list.remove(s);
            }
        }
        System.out.println("List final: ");
        for (Person s : list) {
            System.out.println(s.getName()+", Age: "+s.getAge());
        }

        System.out.println("\nRename john to luther");
        for (Person s : list) {
            if(s.getName().equalsIgnoreCase("john")){
                s.setName("Luther");
            }
        }
        System.out.println("\nFinal list: ");
        for (Person s : list) {
            System.out.println(s.getName()+", Age: "+s.getAge());
        }
    }
}
