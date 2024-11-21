package com.quest.string_builder;

public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer sb1 = new StringBuffer("Hello");
        StringBuffer sb2 = new StringBuffer("World");
        StringBuffer sb3 = new StringBuffer("Hello");
        String sb4 = "World";
        StringBuilder builder = new StringBuilder("Hello");

        //checking stringBuffers
        check1(sb1, sb3);

        //checking stringBuffer and string
        check2(sb2, sb4);

        //checking stringBuilder and stringBuffer
        check3(sb1, builder);

        check4(sb1, sb3);

        check5(sb1, builder);

        check6(sb2);


    }

    public static void check1(StringBuffer sb1, StringBuffer sb2) {
        if (sb1.equals(sb2)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        if (sb1 == sb2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    public static void check2(StringBuffer sb1, String sb2) {
        if (sb1.equals(sb2)) {
            System.out.println("check2 " + true);
        } else {
            System.out.println("check2 " + false);
        }
    }

    public static void check3(StringBuffer sb1, StringBuilder sb2) {
        if (sb1.equals(sb2)) {
            System.out.println("check3 " + true);
        } else {
            System.out.println("check3 " + false);
        }
    }

    public static void check4(StringBuffer sb1, StringBuffer sb2) {
        if (sb1.toString().equals(sb2.toString())) {
            System.out.println("check4 " + true);
        } else {
            System.out.println("check4 " + false);
        }
    }

    public static void check5(StringBuffer sb1, StringBuilder sb2) {
        if (sb1.toString().equals(sb2.toString())) {
            System.out.println("check5 " + true);
        } else {
            System.out.println("check5 " + false);
        }
    }

    public static void check6(StringBuffer sb1) {
        sb1.append("INTERNET");
        System.out.println(sb1);

        sb1.reverse();
        System.out.println(sb1);

        sb1.insert(0, "Wikipedia");
        System.out.println(sb1);

    }
}
