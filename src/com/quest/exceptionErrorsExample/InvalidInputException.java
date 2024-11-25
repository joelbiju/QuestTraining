package com.quest.exceptionErrorsExample;

public class InvalidInputException extends Exception {
    public InvalidInputException(String message, String name) {
        System.out.println(name+" : " + message);

    }
}
