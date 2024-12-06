package com.quest.multiple_inheritance;

public class Main {
    public static void main(String[] args) {
        Impl impl = new Impl();
        impl.printAnimals();
        impl.printCats();
        impl.printDogs();

        Class1.printPlant();
        Class2.printPlant();
    }
}
