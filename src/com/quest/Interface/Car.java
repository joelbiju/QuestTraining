package com.quest.Interface;

public abstract class Car implements Vehicle{
    @Override
    public void wheels() {
        System.out.println("wheels of car");
    }

    @Override
    public void engine() {
        System.out.println("engine of car");
    }
}
