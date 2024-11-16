package com.quest.oops.abstraction;

public class OfflineStudent extends Student {
    @Override
    public void attendClass() {
        System.out.println("Attending offline Classes");
    }

    @Override
    public void submitAssignment() {
        System.out.println("Offline student Submitting assignment");
    }
}
