package com.quest.practice_vars;

import java.util.Scanner;

public class SttudentGradeSystem {
    public static final int MAX_SCORE=100;
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
        System.out.println("Enter the Number of Students: ");
        int number = sc.nextInt();

        for (int i = 0; i < number; i++) {
            Student s = new Student();
            System.out.printf("Enter the Name of Student " + (i + 1) + ": ");
            s.name = sc.next();
            System.out.printf("Enter score for Math (0-100) " + (i + 1) + ": ");
            s.math = sc.nextInt();
            if (!isValidScores(s.math)){
                System.out.println("Invalid Score, enter again");
                s.math = sc.nextInt();
            }
            System.out.printf("Enter score for English (0-100) " + (i + 1) + ": ");
            s.english = sc.nextInt();
            if (!isValidScores(s.english)){
                System.out.println("Invalid Score, enter again");
                s.english = sc.nextInt();
            }
            System.out.printf("Enter score for Science (0-100) " + (i + 1) + ": ");
            s.science = sc.nextInt();
            if (!isValidScores(s.science)){
                System.out.println("Invalid Score, enter again");
                s.science = sc.nextInt();
            }
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

    public static boolean isValidScores(int score){
        return (score >= 0 && score <= MAX_SCORE);
    }
}
