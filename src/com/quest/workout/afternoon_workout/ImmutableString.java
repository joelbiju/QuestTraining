package com.quest.workout.afternoon_workout;

public class ImmutableString {
    public static void main(String[] args) {
        String s1 = "java";
        s1.concat(" is powerful");
        String s2 = s1.concat(" added");
        System.out.println(s1);
        System.out.println(s2);
    }
}
