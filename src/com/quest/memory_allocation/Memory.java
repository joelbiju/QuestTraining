package com.quest.memory_allocation;

public class Memory {
    public static void main(String[] args) {

        //it is defined as literal
        String s1 = "Hello";
        String s2 = "Hello";

        //whenever using 'new' keyword, String objects which create reference in stack area
        String s3 = new String("Hello");
        String s4 = new String("Hell o");

        String s5 = s4;

        int i1=1;
        int i2=1;

        //check2(i1, i2);

        //check(s4, s5);

        String s6 = new String("Hello");
        String s7 = new String("Hello");

        check(s6,s7);
    }

    public static void check(String s1, String s2) {
        if (s1 == s2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        if (s1.equals(s2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        if(s1.contains(s2)){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void check2(int i1, int i2) {
        if (i1 == i2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
