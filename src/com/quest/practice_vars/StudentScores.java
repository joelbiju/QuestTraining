package com.quest.practice_vars;

public class StudentScores {
    public static void main(String[] args) {
        // Step 1: Initialize arrays
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace"};
        int[] ages = {20, 21, 22, 23, 24, 25, 26};
        int[][] scores = {
                {85, 90, 78, 92, -1},
                {88, 92, 80, -1, 85},
                {75, 80, 70, 60, 72},
                {90, 85, 88, 95, 92},
                {65, 70, 60, 68, 67},
                {80, 85, -1, 90, 95},
                {90, 88, 92, 85, 80}
        };

        // Step 2: Calculate average scores
        calculateAverageScores(names, ages, scores);

        // Step 3: Find the highest scorer
        findHighestScorer(names, ages, scores);

        // Step 4: Ranking students by average score
        rankStudents(names, ages, scores);

        // Step 5: Detect missing data
        detectMissingData(names, scores);
    }

    // Method to calculate and print average scores
    public static void calculateAverageScores(String[] names, int[] ages, int[][] scores) {
        for (int i = 0; i < names.length; i++) {
            double sum = 0;
            int count = 0;
            for (int j = 0; j < scores[i].length; j++) {
                sum += scores[i][j];
                count++;
            }
            double average = sum / count;
            System.out.println("Average score for " + names[i] + " is " + average);
        }
        System.out.println();
    }

    // Method to find the student with the highest average score
    public static void findHighestScorer(String[] names, int[] ages, int[][] scores) {
        double max = 0;
        String higherScorer = "";
        for (int i = 0; i < names.length; i++) {
            double sum = 0;
            int count = 0;
            for (int j = 0; j < scores[i].length; j++) {
                sum += scores[i][j];
                count++;
            }
            double average = sum / count;
            if (average > max) {
                max = average;
                higherScorer = names[i];
            }
        }
        System.out.println("Highest score is " + higherScorer + " with score of " + max);
        System.out.println();
    }

    // Method to rank students based on average score
    public static void rankStudents(String[] names, int[] ages, int[][] scores) {
        double[] average = new double[names.length];
        String[] sortedNames = new String[names.length];
        System.arraycopy(names, 0, sortedNames, 0, names.length);

        for (int i = 0; i < names.length; i++) {
            double sum = 0;
            int count = 0;
            for (int j = 0; j < scores[i].length; j++) {
                sum += scores[i][j];
                count++;
            }
            average[i] = sum / count;
        }
        for (int i = 0; i < average.length; i++) {
            for (int j = i + 1; j < average.length; j++) {
                if (average[i] < average[j]) {
                    double temp = average[i];
                    average[i] = average[j];
                    average[j] = temp;
                    String tempName = sortedNames[i];
                    sortedNames[i] = sortedNames[j];
                    sortedNames[j] = tempName;
                }
            }
        }
        System.out.println("Ranking of Students based on scores:");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]+ "- Average Score:"+average[i]);
        }
        System.out.println();
    }

    // Method to detect missing data in the scores array
    public static void detectMissingData(String[] names, int[][] scores) {
        System.out.println("Missing Data on Students:");
        for (int i = 0; i < names.length; i++) {
            boolean missing = false;
            for (int j = 0; j < scores[i].length; j++) {
                if (scores[i][j] == -1) {
                    missing = true;
                    System.out.println(names[i]+" Subject "+(j+1)+" is missing");
                }
            }
            if (!missing) {
                System.out.println(names[i]+" no missing data.");
            }
        }
    }
}
