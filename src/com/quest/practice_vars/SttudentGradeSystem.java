package com.quest.practice_vars;

import java.util.Scanner;

public class SttudentGradeSystem {
    public static final int MAX_SCORE = 100;

    public static void main(String[] args) {
        class Student {
            String name;
            int math;
            int english;
            int science;
            char grade;
            String feedback;
        }
        Scanner sc = new Scanner(System.in);
        int number;
        while (true) {
            System.out.println("Enter the Number of Students: ");
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                if (number > 0) {
                    break;
                } else {
                    System.out.println("Invalid input! Number of students must be greater than 0.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid integer.");
                sc.next(); // Consume invalid input
            }
        }

        for (int i = 0; i < number; i++) {
            Student s = new Student();
            while (true) {
                System.out.printf("Enter the Name of Student " + (i + 1) + ": ");
                s.name = sc.next().trim();
                if (!s.name.isEmpty()) {
                    break;
                } else {
                    System.out.println("Invalid input! Name cannot be empty.");
                }
            }
            s.math = getValidScore(sc, "Math");
            s.english = getValidScore(sc, "English");
            s.science = getValidScore(sc, "Science");
            int totalScore = s.math + s.english + s.science;
            double averageScore = (double) totalScore / 3;
            if (averageScore >= 90) {
                s.grade = 'A';
                s.feedback = "Excellent performance";
            } else if (averageScore >= 80) {
                s.grade = 'B';
                s.feedback = "Good job, but you can aim higher";
            } else if (averageScore >= 70) {
                s.grade = 'C';
                s.feedback = "You need to put in more effort!";
            } else if (averageScore >= 60) {
                s.grade = 'D';
                s.feedback = "Your performance is below expectations. Consider seeking help.";

            } else {
                s.grade = 'F';
                s.feedback = "Failure. You need significant improvement";
            }
            System.out.println("Total Score: " + totalScore);
            System.out.printf("Average Score: %.2f%n", averageScore);
            System.out.println("Grade:" + s.grade);
            System.out.println("Feedback:" + s.feedback);
            if (s.math < 60 || s.english < 60 || s.science < 60) {
                System.out.println("Warning: Needs improvement in individual subjects.");
            }

        }
        System.out.println("Summary: " + number + " students processed.");
    }

    public static boolean isValidScores(int score) {
        return (score >= 0 && score <= MAX_SCORE);
    }

    public static int getValidScore(Scanner sc, String subject) {
        int score = 0;
        while (true) {
            System.out.printf("Enter score for " + subject + " (0-100): ");
            if (sc.hasNextInt()) {
                score = sc.nextInt();
                if (isValidScores(score)) {
                    break;
                } else {
                    System.out.println("Invalid score! Please enter a score between 0 and 100.");
                }
            } else {
                System.out.println("Invalid input! Please enter a valid number for " + subject + " score.");
                sc.next(); // Consume the invalid input
            }
        }
        return score;
    }
}
