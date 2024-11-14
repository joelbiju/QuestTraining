package com.quest.practice_vars;

import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        while (true) {
            System.out.print("Enter the size of array: ");
            size = sc.nextInt();
            if (size > 0) {
                break;
            } else {
                System.out.println("Enter positive valid number");
                sc.nextLine();
            }
        }
        int[] arr = new int[size];
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int[] sortedArray = sortArray(arr);

        System.out.println("Sorted array: ");
        printArray(sortedArray);
    }

    public static int[] sortArray(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    private static void printArray(int[] sortedArray) {
        for (int element : sortedArray) {
            System.out.print(element + " ");
        }
    }
}
