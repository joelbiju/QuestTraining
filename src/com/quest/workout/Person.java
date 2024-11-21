package com.quest.workout;

public class Person {
    protected final String name = "Ron";

    public static class Human {

        Person person = new Person();
        public void printInfo() {
            System.out.println(person.name);
        }
    }

    public static void main(String[] args) {
        Human human = new Human();
        human.printInfo();
    }
}
