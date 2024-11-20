package com.quest.workout;

import java.util.Scanner;

public class MatrixRevert {
    public static void main(String[] args) {
        System.out.println("Matrix Revert Test");
        int[][] matrixA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("Original Matrix:");
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = 0; j < matrixA[i].length; j++) {
                System.out.print(matrixA[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Row reversed matrix:");
        for (int i = 0; i < matrixA.length; i++) {
            for (int j = (matrixA.length - 1); j >= 0; j--) {
                System.out.print(matrixA[i][j] + " ");
            }
            System.out.println();
        }
    }

}
