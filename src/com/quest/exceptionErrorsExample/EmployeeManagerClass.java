package com.quest.exceptionErrorsExample;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeManagerClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Employee employee = null;
        Manager manager = null;

        //employee details
        while (employee == null) {
            try {
                System.out.println("Enter Employee Details");
                System.out.print("Name: ");
                String empName = sc.nextLine();
                System.out.print("Age: ");
                int empAge = sc.nextInt();
                System.out.print("Salary: ");
                double empSalary = sc.nextDouble();
                sc.nextLine();
                employee = new Employee(empName, empAge, empSalary);
            } catch (InvalidInputException | InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        //manager details
        while (manager == null) {
            try {
                System.out.println("Enter Manager Details");
                System.out.print("Name: ");
                String managerName = sc.nextLine();
                System.out.print("Age: ");
                int managerAge = sc.nextInt();
                System.out.print("Salary: ");
                double managerSalary = sc.nextDouble();
                System.out.print("Team Size: ");
                int teamSize = sc.nextInt();
                sc.nextLine();
                manager = new Manager(managerName, managerAge, managerSalary, teamSize);
            } catch (InvalidInputException | InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        //display details
        System.out.println("\nDetails Entered:");
        System.out.println(employee.toString());
        System.out.println(manager.toString());
    }
}
