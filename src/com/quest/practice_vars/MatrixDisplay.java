package com.quest.practice_vars;

import java.util.Scanner;

public class MatrixDisplay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        inputMatrix(rows, cols, matrix, scanner);
        System.out.println("\nThe entered matrix is:");
        printMatrix(rows, cols, matrix);
    }

    private static void inputMatrix(int rows, int cols, int[][] matrix, Scanner scanner) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element at [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    private static void printMatrix(int rows, int cols, int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
