package com.quest.exception_handling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        try{
            performOperations();
        } catch (Exception e){
            System.out.println("Error occurred: "+e.getMessage());
        }
    }

    public static void performOperations() throws ArithmeticException, InputMismatchException, ArrayIndexOutOfBoundsException{
        Scanner sc = new Scanner(System.in);
        int[] arr = {10,20,30,40,50};

        try{
            System.out.print("Enter 1st number: ");
            int num1 = sc.nextInt();
            System.out.print("Enter 2nd number: ");
            int num2 = sc.nextInt();

            int result = num1/num2;
            System.out.println("Result is: "+result);

            System.out.print("Enter an index(0-4): ");
            int index = sc.nextInt();

            System.out.println("Value at index "+index+": "+arr[index]);
        } catch (ArithmeticException e){
            System.out.println("Arithmetic Exception: Division by zero");
        } catch (InputMismatchException e){
            System.out.println("Input mismatch exception: Expected numerals");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException occurred");
        } finally {
            System.out.println("Exception handled");
        }

    }
}
