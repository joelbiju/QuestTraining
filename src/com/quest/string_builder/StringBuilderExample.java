package com.quest.string_builder;

public class StringBuilderExample {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Wikipedia");
        sb.append(" Internet");
        System.out.println(sb);

        //inserting a string
        sb.insert(5, "IN");
        System.out.println(sb);

        //replace text between indexes
        sb.replace(6, 11, "Hello");
        System.out.println(sb);

        //delete a part of the StringBuilder
        sb.delete(5, 6);
        System.out.println(sb);

        //reverse the content of the StringBuilder
        sb.reverse();
        System.out.println(sb);

        //appending a string
        sb.append(",Hello");
        System.out.println(sb);
    }
}
