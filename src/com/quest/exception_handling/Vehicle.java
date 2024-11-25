package com.quest.exception_handling;

import java.io.IOException;

public abstract class Vehicle {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }
    public abstract void startEngine() throws IOException;

    public void displayInfo(){
        System.out.println("Vehicle Name: " + name);
    }
}
