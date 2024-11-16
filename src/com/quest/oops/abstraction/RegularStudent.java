package com.quest.oops.abstraction;

public class RegularStudent extends Student{

    @Override
    public void attendClass() {
        System.out.println("Attending online and offline Classes");
    }

    @Override
    public void submitAssignment() {
        System.out.println("Regular student submitting assignment");
    }
}
