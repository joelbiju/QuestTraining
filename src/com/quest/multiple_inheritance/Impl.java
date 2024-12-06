package com.quest.multiple_inheritance;

public class Impl implements Class1, Class2{
    @Override
    public void printAnimals() {
        System.out.println("Animals printed");
    }

    @Override
    public void printDogs() {
        System.out.println("Dogs printed");
    }

    @Override
    public void printCats() {
        System.out.println("Cats printed");
    }
}
