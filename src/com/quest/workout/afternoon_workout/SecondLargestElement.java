package com.quest.workout.afternoon_workout;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] array1 = {1, 5, 7, 2, 9, 8};
        int max = array1[0];
        int secondMax = 0;
        secondMax = getSecondMax(array1, max, secondMax);
        System.out.println(secondMax);
    }

    private static int getSecondMax(int[] array1, int max, int secondMax) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] > max) {
                max = array1[i];
            }
            if (array1[i] > secondMax && array1[i] != max) {
                secondMax = array1[i];
            }
        }
        return secondMax;
    }
}
