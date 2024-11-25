package com.quest.exceptionErrorsExample;

public class OutOfMemoryError {
    public static void main(String[] args) {
        try{
            causeOutOfMemory();
        } catch (java.lang.OutOfMemoryError e) {
            System.out.println("OutOfMemoryError");
            e.printStackTrace();
        }
    }

    public static void causeOutOfMemory() {
        int size=1;
        while (true){
            int[] arr = new int[size];
            size*=5;
        }
    }
}
