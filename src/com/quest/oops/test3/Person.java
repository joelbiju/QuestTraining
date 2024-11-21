package com.quest.oops.test3;

public class Person {
    private String name = "ABC";

    private void printName(){
        System.out.println(name);
    }
    public void create(){
        printName();
    }

    public class Person1{
        public static void main(String[] args) {
            Person p = new Person();
            p.create();
            p.printName();
        }
    }
}

