package com.quest.oops.practiceInheritance;

public class Cat extends Animal {
    public Cat() {
        super("brown");
        System.out.println("Cat is created");
    }
    public void catBehavior(){
        System.out.println("Cat is silent");
    }
}
