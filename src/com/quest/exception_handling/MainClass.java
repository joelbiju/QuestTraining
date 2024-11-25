package com.quest.exception_handling;

import java.io.IOException;

public class MainClass {
    public static void main(String[] args) {
        Car myCar = new Car("Civic", false);
        Car myCar2 = new Car("Toyota", true);

        try{
            myCar.startEngine();
        } catch (IOException e){
            System.out.println("Error: "+e.getMessage());
        }

        try{
            myCar2.speed(100,0);
        } catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        } finally {
            myCar2.displayInfo();
        }
    }
}
