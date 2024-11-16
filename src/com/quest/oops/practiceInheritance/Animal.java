package com.quest.oops.practiceInheritance;

public class Animal {
    private String Color;
    Animal(String Color) {
        this.Color = Color;
    }
    public void sound(){
        System.out.println("Animal makes sound");
    }
    public void display(){
        System.out.println("All animals are not pets");
    }
}
