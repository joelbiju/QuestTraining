package com.quest.workout.threads;

public class ThreadMultiplier implements Runnable {

    private final int[][] A;
    private final int[][] B;
    private final int[][] C;
    private final int row;

    public ThreadMultiplier(int[][] A, int[][] B, int[][] C, int row) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.row = row;
    }

    @Override
    public void run() {
        int n = A[0].length;    //no. of columns in A
        int p = B[0].length;    //no. of columns in B

        for (int j = 0; j < p; j++) {
            for (int k = 0; k < n; k++) {
                C[row][j] += A[row][k] * B[k][j];
            }
        }
    }
}
