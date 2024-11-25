package com.quest.exception_handling;

public class CustomException {
    public static void main(String[] args) {
        String s = null;

        try {
            System.out.println("The string: " + s.length());
        } catch (NullPointerException e) {
            System.out.println("Exception: "+e);
            e.printStackTrace();
        }


    }
}
