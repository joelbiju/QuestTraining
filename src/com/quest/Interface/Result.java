package com.quest.Interface;

public class Result extends Car {

    public static void main(String[] args) {
        Result r = new Result();
        printing();
        r.wheels();
        r.engine();
    }

    public static void printing() {
        System.out.println("main called");
    }
}
