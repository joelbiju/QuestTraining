package com.quest.workout;

public class FindMissing {
    public static void main(String[] args) {
        int[] arr = {1,3,5,9,13};
        int difference = arr[1]-arr[0];
        int expected = arr[0];
        findMissing(arr, expected, difference);
    }

    private static void findMissing(int[] arr, int expected, int difference) {
        for (int j : arr) {
            if (expected != j) {
                System.out.println(expected);
                expected += difference;
            }
            expected += difference;
        }
    }
}
