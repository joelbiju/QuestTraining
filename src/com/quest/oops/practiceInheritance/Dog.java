package com.quest.oops.practiceInheritance;

public class Dog extends Animal {
    public Dog() {
        super("White");
        System.out.println("Dog is created");
    }

    @Override
    public void sound(){
        System.out.println("Dog barks");
    }
}
