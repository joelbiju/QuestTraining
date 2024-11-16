package com.quest.oops.abstraction;

public class OnlineStudent extends Student{
    public OnlineStudent() {
        System.out.println("Creating online Student");
    }
    @Override
    public void attendClass() {
        System.out.println("Attending online Classes");
    }

    @Override
    public void submitAssignment() {
        System.out.println("Online student submitting assignment");
    }
}
