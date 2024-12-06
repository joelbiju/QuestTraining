package com.quest.workout.afternoon_workout;

public class SwapElements {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};

        swapElements(array1);
    }

    private static void swapElements(int[] array1) {
        int arrayLength = array1.length;
        for (int i = 0; i < arrayLength/2; i++) {
            int temp = array1[i];
            array1[i] = array1[arrayLength-1-i];
            array1[arrayLength-1-i] = temp;
        }
        for (int i = 0; i < arrayLength; i++) {
            System.out.print(array1[i] + " ");
        }
    }
}
