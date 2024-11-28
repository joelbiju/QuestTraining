package com.quest.collections.lists;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<Person>();

        list.add(new Person("John",22,"Male", "Banglore"));
        list.add(new Person("Jane",24, "Female", "Delhi"));
        list.add(new Person("Bob",19, "Male", "Kerala"));
        list.add(new Person("Mary",20, "Female", "Banglore"));

        System.out.println("\nFiltered list using iterator age>20");
        Iterator<Person> iterator = list.iterator();
        while (iterator.hasNext()) {
            Person person = iterator.next();
            if (person.getAge()>21){
                System.out.println(person.getName()+" "+person.getAge()+ " "+person.getLocation());
            }
        }

        System.out.println("\nFiltered list using for loop age<20");
        for (Person person : list) {
            if (person.getAge()<20){
                System.out.println(person.getName()+" "+person.getAge()+ " "+person.getLocation());
            }
        }
    }
}
