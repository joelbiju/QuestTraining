package com.quest.practice_vars;

public class ControlFlow {
    public static void main(String[] args) {
        int number = 10;
        int sum = 0;
        if (number < 0) {
            System.out.println(number + " is negative");
        } else if (number > 0) {
            System.out.println(number + " is positive");
        } else {
            System.out.println(number + " is zero");
        }
        String day = "Monday";
        switch (day) {
            case "Monday":
                System.out.println("Day is " + day);
                break;
            case "Tuesday":
                System.out.println("Day is " + day);
                break;
            case "Wednesday":
                System.out.println("Day is " + day);
                break;
            case "Thursday":
                System.out.println("Day is " + day);
                break;
            case "Friday":
                System.out.println("Day is " + day);
                break;
            case "Saturday":
                System.out.println("Day is " + day);
                break;
            default:
                System.out.println("Invalid ");
                break;
        }
        testForLoop();
    }
    private static void testForLoop(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
    private static void testWhile(){
        int i = 0;
        while (i <= 5) {
            System.out.println(i);
            i++;
        }
    }

}
