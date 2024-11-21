package com.quest.string_builder;

public class StringExample {
    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("hello");
        StringBuilder s2 = new StringBuilder("hello");
        StringBuilder s3 = s1.append(s2);

        check(s1,s2);
    }

    public static void check(StringBuilder s1, StringBuilder s2) {
        if (s1==s2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        if (s1.equals(s2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
