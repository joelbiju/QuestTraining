package com.quest.oops.inheritance;

public class Person {
    private int age;
    public String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public void nameDisplay(){
        String msg=String.format("Student name is %s and age is %d", name, age);
        System.out.println(msg);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
