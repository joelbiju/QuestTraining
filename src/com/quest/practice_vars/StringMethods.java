package com.quest.practice_vars;

public class StringMethods {
    public static void main(String[] args) {
        String str = "Hello World";
        String str2 = "Program in Java";
        String str3 = "hello World";
        String str4 = " Hello World ";

        System.out.println(str2.charAt(5)); //charAt
        System.out.println(str.length());   //length of string
        System.out.println(String.join(", ", str, str2));   //string joining
        System.out.println(str.concat(str2));   //concatenate
        System.out.println(str2.substring(0, 6));   //substring extracted
        System.out.println(str2.substring(8));  //substring from begin index
        System.out.println(str.toUpperCase());  //to uppercase
        System.out.println(str.toLowerCase());  //to lowercase
        System.out.println(str.equals(str3));
        System.out.println(str.equalsIgnoreCase(str3));
        System.out.println(str.compareTo(str2));    //compares through lexicographically
        System.out.println(str4.trim());    //removes blank spaces
        System.out.println(str2.replace('g', 'h')); //character replacement
        System.out.println(str.isEmpty());  //checks if empty
        System.out.println(str.startsWith("He"));   //checks with starts with

        char[] chars = str.toCharArray();
        System.out.println(chars.length);
        System.out.println(chars[3]);



    }
}
