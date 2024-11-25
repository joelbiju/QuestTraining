package com.quest.exceptionErrorsExample;

public class StackError {
    public static void main(String[] args) {
        try{
            causeStackOverflow();
        } catch (StackOverflowError e){
            System.out.println("OverflowError");
            e.printStackTrace();
        }
    }

    public static void causeStackOverflow() {
        causeStackOverflow();
    }

}
