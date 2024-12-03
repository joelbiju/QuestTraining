package com.quest.collections.exercise.map_compare;

import java.util.*;

public class StudentGrades {
    public static void main(String[] args) {
        Map<Student, Integer> studentGrades = new HashMap<>();

        Student student1 = new Student("Max");
        Student student2 = new Student("Alice");
        Student student3 = new Student("Ron");
        Student student4 = new Student("David");
        Student student5 = new Student("Steve");

        studentGrades.put(student1, 70);
        studentGrades.put(student2, 90);
        studentGrades.put(student3, 85);
        studentGrades.put(student4, 80);
        studentGrades.put(student5, 75);

        List<Map.Entry<Student,Integer>> entries = new ArrayList<>();
        for (Map.Entry<Student, Integer> entry : studentGrades.entrySet()) {
            entries.add(entry);
        }

        entries.sort(new GradeComparator());
        studentGrades = new LinkedHashMap<>();
        for (Map.Entry<Student, Integer> entry : entries) {
            studentGrades.put(entry.getKey(), entry.getValue());
        }

        System.out.println("Sorted values: ");
        for (Map.Entry<Student, Integer> entry : studentGrades.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
