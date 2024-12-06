package com.quest.workout.afternoon_workout;

public class SquarePattern {
    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 10; j++) {
                if (i == 1 || i == 6 || j == 1 || j == 10) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
