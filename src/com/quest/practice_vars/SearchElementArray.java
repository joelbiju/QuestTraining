package com.quest.practice_vars;

import java.util.Scanner;

public class SearchElementArray {

    public static int searchElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

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
        System.out.println("Enter the elements in array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the elements to be searched: ");
        int element = sc.nextInt();
        int index = searchElement(arr, element);
        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + index);
        }
    }
}
